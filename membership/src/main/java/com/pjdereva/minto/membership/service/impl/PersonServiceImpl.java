package com.pjdereva.minto.membership.service.impl;

import com.pjdereva.minto.membership.dto.application.PersonDTO;
import com.pjdereva.minto.membership.mapper.*;
import com.pjdereva.minto.membership.model.*;
import com.pjdereva.minto.membership.model.transaction.LifeStatus;
import com.pjdereva.minto.membership.repository.*;
import com.pjdereva.minto.membership.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;
    private final EmailRepository emailRepository;
    private final PhoneRepository phoneRepository;
    private final PersonMapper personMapper;
    private final ContactMapper contactMapper;
    private final AddressMapper addressMapper;
    private final EmailMapper emailMapper;
    private final PhoneMapper phoneMapper;

    @Override
    public Optional<Person> addNewPerson(PersonDTO personDTO) {
        try {
            if (!personRepository.existsByFirstNameAndLastNameAndDob(personDTO.getFirstName(), personDTO.getLastName(), LocalDate.parse(personDTO.getDob()))) {
                Contact contact = new Contact();

                Set<Address> addresses = addressMapper.addressDTOSetToAddressSet(new HashSet<>(personDTO.getContact().getAddresses()));
                addresses.forEach(address -> {
                    Address addressObj = Address.builder()
                            .contact(contact)
                            .addressType(address.getAddressType())
                            .street(address.getStreet())
                            .city(address.getCity())
                            .state(address.getState())
                            .zipcode(address.getZipcode())
                            .country(address.getCountry())
                            .build();
                    contact.addAddress(addressObj);
                });

                Set<Email> emails = emailMapper.emailDTOSetToEmailSet(new HashSet<>(personDTO.getContact().getEmails()));
                emails.forEach(email -> {
                    Email emailObj = Email.builder()
                            .contact(contact)
                            .emailType(email.getEmailType())
                            .address(email.getAddress())
                            .build();
                    contact.addEmail(emailObj);
                });

                Set<Phone> phones = phoneMapper.phoneDTOSetToPhoneSet(new HashSet<>(personDTO.getContact().getPhones()));
                phones.forEach(phone -> {
                    Phone phoneObj = Phone.builder()
                            .contact(contact)
                            .phoneType(phone.getPhoneType())
                            .countryCode(phone.getCountryCode())
                            .number(phone.getNumber())
                            .build();
                    contact.addPhone(phoneObj);
                });

                Person newPerson = Person.builder()
                        .firstName(personDTO.getFirstName())
                        .middleName(personDTO.getMiddleName())
                        .lastName(personDTO.getLastName())
                        .dob(LocalDate.parse(personDTO.getDob()))
                        .lifeStatus(personDTO.getLifeStatus())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .contact(contact)
                        .build();
                Person savedPerson = personRepository.save(newPerson);
                return Optional.of(savedPerson);
            } else {
                log.warn("Person already exists with same firstName: {}, lastName: {}, and dob: {}",
                        personDTO.getFirstName(), personDTO.getLastName(), personDTO.getDob());
                return Optional.empty();
            }
        } catch (Exception e) {
            log.error("Error adding new person: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Person> createPerson(PersonDTO personDTO) {
        try {
            if (!personRepository.existsByFirstNameAndLastNameAndDob(personDTO.getFirstName(), personDTO.getLastName(), LocalDate.parse(personDTO.getDob()))) {
                Contact contact = new Contact();
                contactRepository.save(contact);

                Set<Address> addresses = addressMapper.addressDTOSetToAddressSet(new HashSet<>(personDTO.getContact().getAddresses()));
                addresses.forEach(address -> {
                    Address addressObj = Address.builder()
                            .contact(contact)
                            .addressType(address.getAddressType())
                            .street(address.getStreet())
                            .city(address.getCity())
                            .state(address.getState())
                            .zipcode(address.getZipcode())
                            .country(address.getCountry())
                            .build();
                    addressRepository.save(addressObj);
                    contact.addAddress(addressObj);
                });

                Set<Email> emails = emailMapper.emailDTOSetToEmailSet(new HashSet<>(personDTO.getContact().getEmails()));
                emails.forEach(email -> {
                    Email emailObj = Email.builder()
                            .contact(contact)
                            .emailType(email.getEmailType())
                            .address(email.getAddress())
                            .build();
                    emailRepository.save(emailObj);
                    contact.addEmail(emailObj);
                });

                Set<Phone> phones = phoneMapper.phoneDTOSetToPhoneSet(new HashSet<>(personDTO.getContact().getPhones()));
                phones.forEach(phone -> {
                    Phone phoneObj = Phone.builder()
                            .contact(contact)
                            .phoneType(phone.getPhoneType())
                            .countryCode(phone.getCountryCode())
                            .number(phone.getNumber())
                            .build();
                    phoneRepository.save(phoneObj);
                    contact.addPhone(phoneObj);
                });

                Person newPerson = Person.builder()
                        .firstName(personDTO.getFirstName())
                        .middleName(personDTO.getMiddleName())
                        .lastName(personDTO.getLastName())
                        .dob(LocalDate.parse(personDTO.getDob()))
                        .lifeStatus(personDTO.getLifeStatus())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .contact(contact)
                        .build();
                Person savedPerson = personRepository.save(newPerson);
                return Optional.of(savedPerson);
            } else {
                log.warn("Person already exists with the same firstName: {}, lastName: {}, and dob: {}",
                        personDTO.getFirstName(), personDTO.getLastName(), personDTO.getDob());
                return Optional.empty();
            }
        } catch (Exception e) {
            log.error("Error creating person: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {
        var person = personRepository.save(personMapper.toPerson(personDTO));
        return personMapper.toPersonDTO(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAllWithFullContact();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findByIdWithFullContact(id);
    }

    @Override
    public boolean existById(Long id) {
        return personRepository.existsById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        person.setUpdatedAt(LocalDateTime.now());
        return personRepository.save(person);
    }

    @Override
    public boolean deletePersonById(Long id) {
        try {
            personRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public PersonDTO updatePersonById(Long id, Map<String, Object> updates) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            // Update person fields based on the provided updates
            if (updates.containsKey("firstName")) {
                person.setFirstName((String) updates.get("firstName"));
            }
            if (updates.containsKey("middleName")) {
                person.setMiddleName((String) updates.get("middleName"));
            }
            if (updates.containsKey("lastName")) {
                person.setLastName((String) updates.get("lastName"));
            }
            if (updates.containsKey("dob")) {
                person.setDob((LocalDate) updates.get("dob"));
            }
            if (updates.containsKey("lifeStatus")) {
                person.setLifeStatus(LifeStatus.valueOf((String) updates.get("lifeStatus")));
            }
            if (updates.containsKey("contact")) {
                person.setContact((Contact) updates.get("contact"));
            }
            person.setUpdatedAt(LocalDateTime.now());
            return personMapper.toPersonDTO(personRepository.save(person));
        }
        return null;
    }
}
