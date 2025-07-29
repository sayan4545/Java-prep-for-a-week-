package com.dev.sayan.inventorymanagementsystem.ordersservice.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long id;
    private List<OrderRequestItemDTO> orderRequestItemDTOList;
    private BigDecimal totalPrice;
}
