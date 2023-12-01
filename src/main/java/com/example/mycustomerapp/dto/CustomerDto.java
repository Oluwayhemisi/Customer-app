package com.example.mycustomerapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class CustomerDto {
    Long id;
    String fullName;
    String phoneNumber;
    LocalDate dateJoined;
}
