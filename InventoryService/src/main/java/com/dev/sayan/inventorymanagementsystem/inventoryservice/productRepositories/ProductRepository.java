package com.dev.sayan.inventorymanagementsystem.inventoryservice.productRepositories;

import com.dev.sayan.inventorymanagementsystem.inventoryservice.productEntities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
