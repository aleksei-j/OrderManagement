package com.alekseij.OrderManagement.controller;

import com.alekseij.OrderManagement.model.Product;
import com.alekseij.OrderManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "{productId}")
    public Product getProduct(@PathVariable ("productId") Long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Long productId(@RequestBody Product product) {
        productService.postNewProduct(product);
        return product.getProductId();
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable ("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(@PathVariable ("productId") Long productId, @RequestParam(required = false) String name,
                              @RequestParam(required = false) String skuCode,@RequestParam(required = false) Long unitPrice) {
        productService.updateProductName(productId, name);
        productService.updateProductSkuCode(productId, skuCode);
        productService.updateProductPrice(productId, unitPrice);

    }


}
