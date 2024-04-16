package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/warehouses")
public class StorageManagementController {

    private Warehouse generateWarehouseWithProducts() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("New Warehouse " + new Random().nextInt(1000));
        warehouse.setAddress("New Address " + new Random().nextInt(100));
        warehouse.setParkinslots(new Random().nextInt(50));
        warehouse.setStorage(new Random().nextInt(10000));

        List<Product> products = createProducts(warehouse);
        warehouse.setProducts(products);

        return warehouse;
    }

    private List<Product> createProducts(Warehouse warehouse) {
        List<Product> products = new ArrayList<>();
        Random rand = new Random();
        int count = rand.nextInt(5) + 1;

        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setName("Item " + (i + 1));
            product.setPrice(rand.nextInt(100));
            product.setAvaibility(rand.nextBoolean());
            product.setStock(rand.nextInt(20) + 1);
            product.setWarehouse(warehouse);
            products.add(product);
        }
        return products;
    }

    @Autowired
    private WarehouseRepository warehouseRepo;

    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addWarehouseWithProducts() {
        try {
            Warehouse newWarehouse = generateWarehouseWithProducts();

            warehouseRepo.save(newWarehouse);
            return new ResponseEntity<>("Warehouse successfully added with products", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAllWarehouses() {
        try {
            List<Warehouse> allWarehouses = warehouseRepo.findAll();
            if (!allWarehouses.isEmpty()) {
                return new ResponseEntity<>(allWarehouses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No warehouses available", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error listing warehouses", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
