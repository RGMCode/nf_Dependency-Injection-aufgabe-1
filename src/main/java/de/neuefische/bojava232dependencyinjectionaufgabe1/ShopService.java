package de.neuefische.bojava232dependencyinjectionaufgabe1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public Product getProduct(String id) {
        return productRepo.get(id);
    }

    public List<Product> listProducts() {
        return productRepo.list();
    }

    public Order getOrder(String id) {
        return orderRepo.get(id);
    }

    public List<Order> listOrders() {
        return orderRepo.list();
    }

    public void addOrder(List<String> productIds) throws OrderNotFoundException {
        // Validation
        for (String productId : productIds) {
            if (productRepo.get(productId) == null) {
                throw new OrderNotFoundException();
            }
        }

        // Product IDs to Product
        List<Product> products = new ArrayList<>();
        for (String productId: productIds) {
            Product product = productRepo.get(productId);
            products.add(product);
        }

        // Add order
        Order order = new Order(UUID.randomUUID().toString(), products);

        orderRepo.add(order);
    }
}
