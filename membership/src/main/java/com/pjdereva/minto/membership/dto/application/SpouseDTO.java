package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.transaction.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpouseDTO {

    private Long id;
    private PersonDTO person;
    private MaritalStatus maritalStatus;
    private String notes;
}
