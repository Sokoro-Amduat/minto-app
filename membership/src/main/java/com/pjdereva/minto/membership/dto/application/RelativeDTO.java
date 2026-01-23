package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.transaction.FamilyRelationship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelativeDTO {

    private Long id;
    private ApplicationDTO application;
    private PersonDTO person;
    private String membershipNumber;
    private FamilyRelationship familyRelationship;
    private String notes;
}
