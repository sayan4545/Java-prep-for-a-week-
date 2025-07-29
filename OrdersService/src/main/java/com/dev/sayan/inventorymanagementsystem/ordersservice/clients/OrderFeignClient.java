package com.dev.sayan.inventorymanagementsystem.ordersservice.clients;

import com.dev.sayan.inventorymanagementsystem.ordersservice.dtos.OrderRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "InventoryService", path = "/inventory")
public interface OrderFeignClient {

    @PutMapping("/products/reduceStock")
    public Double reduceStock(@RequestBody OrderRequestDTO orderRequestDTO);
}
