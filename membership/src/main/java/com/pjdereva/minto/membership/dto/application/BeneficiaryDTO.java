package com.pjdereva.minto.membership.dto.application;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BeneficiaryDTO {

    private Long id;
    private PersonDTO person;
    private BigDecimal percentage;
    private String relationship;
    private String notes;
}
