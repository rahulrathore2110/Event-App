package com.event.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    private String vendorName;
    private String bankAccountNumber;
    private String bankName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String zipCode;
}
