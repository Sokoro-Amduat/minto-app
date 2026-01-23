package com.pjdereva.minto.membership.dto;


import com.pjdereva.minto.membership.dto.application.ApplicationDTO;
import com.pjdereva.minto.membership.dto.application.PersonDTO;
import com.pjdereva.minto.membership.model.transaction.MembershipStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {

    private Long id;
    private String membershipNumber;
    private GetUserDTO user;
    private PersonDTO person;
    private ApplicationDTO application;
    private MembershipStatus status;
    private String startDate;
    private String endDate;
    private String renewalDate;
    private String terminationDate;
    private String memberCreatedAt;
    private String memberUpdatedAt;
    private String notes;
    private String terminationReason;
}
