package com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos;

import lombok.*;

@Data

public class ProductDTO {

    private Long id;
    private String title;
    private Double price;
    private Integer stock;
}
