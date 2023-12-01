package com.example.mycustomerapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerDto {
    Long id;
    String fullName;
    String phoneNumber;
}
