package com.dev.sayan.inventorymanagementsystem.ordersservice.repositories;

import com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersEntities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
