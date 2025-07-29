package com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private List<OrderRequestItemDTO> orderItems;
}
