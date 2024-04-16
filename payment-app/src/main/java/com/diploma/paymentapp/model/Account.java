package com.diploma.paymentapp.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Сущность аккаунта.
 */
@Data
@Entity
@Table(name = "bank_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private Long number;
    @Column(name = "balance")
    private BigDecimal balance;
}
