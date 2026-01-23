package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.transaction.ParentType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentDTO {

    private Long id;
    private PersonDTO person;
    private ParentType parentType;
    private String notes;
}
