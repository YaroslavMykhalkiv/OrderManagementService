package com.example.oms.controller;

import com.example.oms.model.Order;
import com.example.oms.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService svc;

    public OrderController(OrderService svc){
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order){
        Order created = svc.create(order);
        return ResponseEntity.created(URI.create("/api/orders/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id){
        return svc.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Order> list(){
        return svc.list();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestBody String status){
        Order updated = svc.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }
}
