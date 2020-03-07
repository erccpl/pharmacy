package com.pharmacy.manufacturer;

import com.pharmacy.company.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "M")
@NoArgsConstructor
@Getter
@Setter
public class Manufacturer extends Company {


}
