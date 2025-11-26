package com.example.oms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer;

    private Double amount;

    private String status;

    private LocalDateTime createdAt;

    public Order() {}

    public Order(String customer, Double amount, String status) {
        this.customer = customer;
        this.amount = amount;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getCustomer(){return customer;}
    public void setCustomer(String customer){this.customer=customer;}
    public Double getAmount(){return amount;}
    public void setAmount(Double amount){this.amount=amount;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}
