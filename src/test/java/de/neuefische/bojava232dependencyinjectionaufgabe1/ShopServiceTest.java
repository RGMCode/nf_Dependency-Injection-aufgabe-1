package de.neuefische.bojava232dependencyinjectionaufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class ShopServiceTest {

    ShopService shopService = mock(ShopService.class);
    ProductRepo productRepo = mock(ProductRepo.class);
    OrderRepo orderRepo = mock(OrderRepo.class);


    @Test
    public void getProduct_whenId_thenProduct(){
        Product expectedProduct = new Product("1", "Product Name");
        Mockito.when(shopService.getProduct("1")).thenReturn(expectedProduct);
        Product actualProduct = shopService.getProduct("1");
        Assertions.assertEquals(expectedProduct, actualProduct);
        Mockito.verify(shopService).getProduct("1");
    }



    @Test
    public void listProducts_whenList_thenProducts() {

        Mockito.when(productRepo.list()).thenReturn(List.of(new Product("10", "Bannane")));

        ShopService shopService = new ShopService(productRepo, orderRepo);

        Assertions.assertEquals(
                List.of(new Product("10", "Bannane")),
                shopService.listProducts()
        );
        Mockito.verify(productRepo).list();
    }



}