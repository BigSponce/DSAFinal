package com.keyin.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<Product>>getProductByParam(@RequestParam Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/sorted-by-price")
    public ResponseEntity<Iterable<Product>> getAllProductsSortedByPrice() {
        return ResponseEntity.ok(productService.findAllProductsSortedByPrice());
    }

    @GetMapping("/sorted-by-stock")
    public ResponseEntity<Iterable<Product>> getAllProductsSortedByStock() {
        return ResponseEntity.ok(productService.findAllProductsSortedByStock());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        productService.removeProductById(id);
        return ResponseEntity.ok("Product with ID " + id + " removed successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok("Product with ID " + id + " updated successfully");
    }


}