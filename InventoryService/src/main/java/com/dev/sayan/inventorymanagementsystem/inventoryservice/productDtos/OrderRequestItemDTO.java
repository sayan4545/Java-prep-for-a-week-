package com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos;

import lombok.Data;

@Data
public class OrderRequestItemDTO {

    private Long productId;
    private Integer quantity;
}
