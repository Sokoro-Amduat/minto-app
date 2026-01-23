package com.pjdereva.minto.membership.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefereeDTO {

    private Long id;
    private ApplicationDTO application;
    private PersonDTO person;
    private String membershipNumber;
    private String referenceDate;
    private boolean contacted;
    private String comments;
    private String notes;
}
