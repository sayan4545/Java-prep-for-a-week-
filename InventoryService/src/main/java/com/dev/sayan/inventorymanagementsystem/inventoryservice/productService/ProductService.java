package com.dev.sayan.inventorymanagementsystem.inventoryservice.productService;

import com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos.OrderRequestDTO;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos.OrderRequestItemDTO;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productDtos.ProductDTO;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productEntities.ProductEntity;
import com.dev.sayan.inventorymanagementsystem.inventoryservice.productRepositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllInventories(){
        log.info("fetching all inventory items");
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(productEntity -> modelMapper.map(productEntity,ProductDTO.class))
                .toList();
    }

    public ProductDTO getProductById(Long id){
        log.info("fetching product by id"+id);
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.map(productEntity -> modelMapper.map(productEntity,ProductDTO.class))
                .orElseThrow(()-> new RuntimeException("Inventory not found"));
    }

    public ProductDTO savePost(ProductDTO productDTO){
        ProductEntity productEntity = modelMapper.map(productDTO,ProductEntity.class);
        productRepository.save(productEntity);
        return modelMapper.map(productEntity,ProductDTO.class);
    }
    @Transactional
    public Double reduceStock(OrderRequestDTO orderRequestDTO) {

        Double totalPrice = 0.0;
        for(OrderRequestItemDTO orderRequestItemDTO:orderRequestDTO.getOrderItems()){
            if(orderRequestItemDTO.getQuantity()>0){
                Long productId =  orderRequestItemDTO.getProductId();
                Integer quantity = orderRequestItemDTO.getQuantity();
                if(productRepository.findById(productId).isPresent()){
                    ProductEntity productEntity = productRepository.findById(productId).get();
                    if (productEntity.getStock()>quantity){
                        productEntity.setStock(productEntity.getStock()-quantity);
                        productRepository.save(productEntity);
                        totalPrice += quantity*productEntity.getPrice();
                    }
                    else{
                        throw new RuntimeException("Product not enough");
                    }
                }
                else{
                    throw new RuntimeException("Product not present ");
                }
            }
            else{
                throw new RuntimeException("Quantity cannot be negative");
            }

        }
        return totalPrice;
    }
}
