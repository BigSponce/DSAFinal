package com.keyin.order;

import java.util.ArrayList;
import java.util.List;

class OrderNode {
    Order data;
    OrderNode left;
    OrderNode right;

    public OrderNode(Order data) {
        this.data = data;
    }
}

public class BinarySearchTree {

    OrderNode root;

    public void insert(Order order) {
        root = insertRecursive(root, order);
    }

    private OrderNode insertRecursive(OrderNode current, Order order) {

        if (current == null) {
            return new OrderNode(order);
        }

        if (order.getPriorityLevel() < current.data.getPriorityLevel()) {
            current.left = insertRecursive(current.left, order);
        } else {
            current.right = insertRecursive(current.right, order);
        }

        return current;
    }

    public void inorder(OrderNode node, java.util.List<Order> orders) {
        if (node == null) return;

        inorder(node.right, orders);
        orders.add(node.data);
        inorder(node.left, orders);
    }

    public List<Order> inorderTraversal() {
        List<Order> orders = new ArrayList<>();
        inorder(root, orders);
        return orders;
    }

    public Order findHighest() {
        OrderNode current = root;
        if (current == null) return null;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    public Order findLowest() {
        OrderNode current = root;
        if (current == null) return null;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }
}