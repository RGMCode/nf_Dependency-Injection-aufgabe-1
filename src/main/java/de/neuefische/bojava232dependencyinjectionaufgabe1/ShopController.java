package de.neuefische.bojava232dependencyinjectionaufgabe1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return shopService.listProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable String id) {
        return shopService.getProduct(id);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return shopService.listOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrdersById(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @PostMapping("/orders")
    public void postOrderById(@RequestBody List<String> productIds) throws OrderNotFoundException {
        shopService.addOrder(productIds);
    }
}
