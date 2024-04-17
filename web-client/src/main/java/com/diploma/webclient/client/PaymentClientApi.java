package com.diploma.webclient.client;


import com.diploma.webclient.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment")
public interface PaymentClientApi {
    @PostMapping()
    ResponseEntity<?> pay(@RequestBody Transaction transaction);
}
