package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    private Long id;
    private AddressType addressType;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
