package com.diploma.webclient.client;

import com.diploma.webclient.model.Order;
import com.diploma.webclient.model.ShirtStoreMnf;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "storage")
public interface StorageClientApi {
    @GetMapping
    List<ShirtStoreMnf> getProducts();

    @PostMapping("/{id}")
    ResponseEntity<?> buy(@PathVariable Long id, @RequestBody Order order);

}
