package com.alekseij.OrderManagement.service;

import com.alekseij.OrderManagement.model.Product;
import com.alekseij.OrderManagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException("Product with productId:" + productId + " not found"));
    }

    public List<Product> getProducts() {return productRepository.findAll(); }

    public void postNewProduct(Product product) {productRepository.save(product); }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);

        if (!exists) {
            throw new IllegalStateException("Product with productId: " + productId + " not found");
        }

        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProductName(Long productId, String name) {

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException("Product with productId:" + productId + " not found"));

        product.setName(name);
    }

    @Transactional
    public void updateProductSkuCode(Long productId, String skuCode) {

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException("Product with productId:" + productId + " not found"));

        product.setSkuCode(skuCode);
    }

    @Transactional
    public void updateProductPrice(Long productId, Long unitPrice) {

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException("Product with productId:" + productId + " not found"));

        product.setUnitPrice(unitPrice);
    }
}
