package com.keyin.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findOrderById(id));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-to-priority-tree")
    public ResponseEntity<String> addToPriorityTree(@RequestBody Order order) {
        orderService.addToPriorityTree(order);
        return ResponseEntity.ok("Order added to priority tree");
    }

    @GetMapping("/priority/inorder")
    public ResponseEntity<List<Order>> getInorderTraversal() {
        return ResponseEntity.ok(orderService.getInOrderTraversal());
    }

    @GetMapping("/priority/highest")
    public ResponseEntity<Order> getHighestPriorityOrder() {
        return ResponseEntity.ok(orderService.getHighestPriorityOrder());
    }

    @GetMapping("/priority/lowest")
    public ResponseEntity<Order> getLowestPriorityOrder() {
        return ResponseEntity.ok(orderService.getLowestPriorityOrder());
    }
}