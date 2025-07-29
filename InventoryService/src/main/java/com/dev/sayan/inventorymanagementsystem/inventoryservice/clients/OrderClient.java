package com.dev.sayan.inventorymanagementsystem.inventoryservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OrdersService",path = "/orders")

public interface OrderClient {

    @GetMapping("/core/helloOrders")
    String  helloOrder();


}
