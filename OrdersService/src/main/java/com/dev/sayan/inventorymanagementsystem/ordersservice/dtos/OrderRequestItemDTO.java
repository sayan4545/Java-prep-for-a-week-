package com.dev.sayan.inventorymanagementsystem.ordersservice.dtos;

import lombok.Data;

@Data
public class OrderRequestItemDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
}
