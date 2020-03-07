package com.pharmacy.contact_details;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class ContactDetails {

    private String city;
    private String street;
    private String postalCode;
    private String phone;
    private String email;

}

