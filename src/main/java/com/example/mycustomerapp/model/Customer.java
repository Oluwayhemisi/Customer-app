package com.example.mycustomerapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Setter
@Getter
@Table(name = "Customers-app")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "FullName")
    String fullName;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "dateJoined")
    LocalDate dateJoined;
}
