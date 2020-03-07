package com.pharmacy.company;

import com.pharmacy.contact_details.ContactDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE")
@Getter
@Setter
public abstract class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @Embedded
    private ContactDetails contactDetails;
}
