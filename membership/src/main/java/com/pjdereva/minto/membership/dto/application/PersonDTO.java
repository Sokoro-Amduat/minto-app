package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.transaction.LifeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private LifeStatus lifeStatus;
    private String createdAt;
    private String updatedAt;
    private ContactDTO contact;
}
