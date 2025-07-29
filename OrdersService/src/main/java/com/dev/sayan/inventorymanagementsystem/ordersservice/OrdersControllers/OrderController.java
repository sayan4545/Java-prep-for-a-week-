package com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersControllers;

import com.dev.sayan.inventorymanagementsystem.ordersservice.OrdersServices.OrderService;
import com.dev.sayan.inventorymanagementsystem.ordersservice.dtos.OrderRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/core")
public class OrderController {

    private final OrderService  orderService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderRequestDTO>> getAllOrders() {
        log.info("Fetch orders");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/askOrder")
    public ResponseEntity<OrderRequestDTO> askOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.askOrder(orderRequestDTO));
    }

    @GetMapping("/helloOrders")
    public String helloOrders(){
        return "Hello from order service";
    }

    @GetMapping("/getOrderByid/{id}")
    public ResponseEntity<OrderRequestDTO> getOrderByid(@PathVariable("id") Long id) {
        log.info("Fetch order by id"+id);
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderRequestDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        log.info("Create order");
        return ResponseEntity.ok(orderService.createOrder(orderRequestDTO));
    }


}
