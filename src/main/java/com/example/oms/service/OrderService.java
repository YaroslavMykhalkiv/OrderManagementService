package com.example.oms.service;

import com.example.oms.model.Order;
import com.example.oms.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo){
        this.repo = repo;
    }

    @Transactional
    public Order create(Order order){
        order.setStatus("CREATED");
        order.setCreatedAt(LocalDateTime.now());
        return repo.save(order);
    }

    public Optional<Order> get(Long id){
        return repo.findById(id);
    }

    public List<Order> list(){
        return repo.findAll();
    }

    @Transactional
    public Order updateStatus(Long id, String status){
        Order o = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
        o.setStatus(status);
        return repo.save(o);
    }
}
