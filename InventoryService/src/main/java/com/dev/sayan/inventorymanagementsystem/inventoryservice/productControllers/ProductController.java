package com.dev.sayan.inventorymanagementsystem.inventoryservice.productControllers;

import com.dev.sayan.inventorymanagementsystem.inventoryservice.clients.OrderClient;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos.OrderRequestDTO;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos.ProductDTO;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productRepositories.ProductRepository;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productService.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class ProductController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    private final OrderClient  orderClient;

    private final ProductService productService;

    @GetMapping("/fetchOrders")
    public ResponseEntity<String> fetchOrdersFromOrdersService(){
//        ServiceInstance serviceInstance = discoveryClient.getInstances("OrdersService").get(0);
//        return ResponseEntity.ok(restClient.get().uri(serviceInstance.getUri()+"/orders/core/helloOrders").retrieve().body(String.class));
        log.info("fetchOrdersFromOrdersService");
        return ResponseEntity.ok(orderClient.helloOrder());

    }

    @PutMapping("/reduceStock")
    public ResponseEntity<Double> reduceStock(@RequestBody OrderRequestDTO orderRequestDTO){

        Double totalPrice = productService.reduceStock(orderRequestDTO);
        return ResponseEntity.ok(totalPrice);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        log.info("getAllProducts");
        return ResponseEntity.ok(productService.getAllInventories());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        log.info("getProductById"+id);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
        log.info("saveProduct"+productDTO);
        return ResponseEntity.ok(productService.savePost(productDTO));
    }

}
