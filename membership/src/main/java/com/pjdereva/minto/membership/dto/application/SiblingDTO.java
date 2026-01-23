package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.transaction.SiblingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiblingDTO {

    private Long id;
    private PersonDTO person;
    private SiblingType siblingType;
    private String notes;
}
