package com.keyin.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.annotation.PostConstruct;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final BinarySearchTree priorityTree = new BinarySearchTree();

    @PostConstruct
    public void init() {
        Iterable<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            priorityTree.insert(order);
        }
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order order) {
        Optional<Order> existingOrder = orderRepository.findById(id);

        if (existingOrder.isPresent()) {
            Order orderFromDb = existingOrder.get();

            orderFromDb.setOrderDate(order.getOrderDate());
            orderFromDb.setPriorityLevel(order.getPriorityLevel());
            orderFromDb.setCustomer(order.getCustomer());

            return orderRepository.save(orderFromDb);

        } else {
            throw new RuntimeException("Order not found");
        }
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public void addToPriorityTree(Order order) {
        priorityTree.insert(order);
    }

    public List<Order> getInOrderTraversal() {
        return priorityTree.inorderTraversal();
    }

    public Order getHighestPriorityOrder() {
        return priorityTree.findHighest();
    }

    public Order getLowestPriorityOrder() {
        return priorityTree.findLowest();
    }
}