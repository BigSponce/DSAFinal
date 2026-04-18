package com.keyin.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {return productRepository.save(product);}

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getId());

        if (existingProduct.isPresent()) {
            Product productFromDb = existingProduct.get();

            productFromDb.setName(product.getName());
            productFromDb.setPrice(product.getPrice());
            productFromDb.setStock(product.getStock());

            return productRepository.save(productFromDb);

        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Iterable<Product> findAllProductsSortedByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    public Iterable<Product> findAllProductsSortedByStock() {
        return productRepository.findAllByOrderByStockAsc();
    }
}