package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Product {
    @ManyToOne//(fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @Column
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private boolean avaibility;

    @Column
    private Integer stock;

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isAvaibility() {
        return avaibility;
    }

    public void setAvaibility(boolean avaibility) {
        this.avaibility = avaibility;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
