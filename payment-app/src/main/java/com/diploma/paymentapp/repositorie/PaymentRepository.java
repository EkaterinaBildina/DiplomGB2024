package com.diploma.paymentapp.repositorie;

import com.diploma.paymentapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Account, Long> {
    Account findByNumber(Long number);
}
