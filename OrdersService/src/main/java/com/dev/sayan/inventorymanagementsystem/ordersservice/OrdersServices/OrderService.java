package com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersServices;

import com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersEntities.Order;
import com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersEntities.OrderItem;
import com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersEntities.enums.OrderStatus;
import com.dev.sayan.inventorymanagementsystem.ordersservice.clients.OrderFeignClient;
import com.dev.sayan.inventorymanagementsystem.ordersservice.dtos.OrderRequestDTO;
import com.dev.sayan.inventorymanagementsystem.ordersservice.dtos.OrderRequestItemDTO;
import com.dev.sayan.inventorymanagementsystem.ordersservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final OrderFeignClient  orderFeignClient;

    public List<OrderRequestDTO> getAllOrders(){
        log.info("Fetch all orders");
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderRequestDTO.class)).collect(Collectors.toList());

    }

    public OrderRequestDTO getOrderById(Long id){
        log.info("Fetch order by id"+id);
        Order order = orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found any order"));
        return modelMapper.map(order, OrderRequestDTO.class);
    }

    public OrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO){
        Order order = modelMapper.map(orderRequestDTO, Order.class);
        order = orderRepository.save(order);
        return modelMapper.map(order, OrderRequestDTO.class);
    }

    public OrderRequestDTO askOrder(OrderRequestDTO orderRequestDTO){
        Double totalPrice = orderFeignClient.reduceStock(orderRequestDTO);
        Order order = modelMapper.map(orderRequestDTO, Order.class);
        for(OrderItem orderItem:order.getOrderItems()){
            orderItem.setOrder(order);

        }
        order.setPrice(totalPrice);
        order.setOrderStatus(OrderStatus.CONFIRMED);
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderRequestDTO.class);

    }


}
