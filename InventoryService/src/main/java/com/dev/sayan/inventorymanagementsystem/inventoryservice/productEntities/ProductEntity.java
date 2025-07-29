package com.dev.sayan.inventorymanagementsystem.inventoryservice.productEntities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private Integer stock;
}
