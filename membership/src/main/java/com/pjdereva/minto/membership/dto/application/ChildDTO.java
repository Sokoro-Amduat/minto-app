package com.pjdereva.minto.membership.dto.application;

import com.pjdereva.minto.membership.model.transaction.ChildType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildDTO {

    private Long id;
    private PersonDTO person;
    private ChildType childType;
    private String notes;
}
