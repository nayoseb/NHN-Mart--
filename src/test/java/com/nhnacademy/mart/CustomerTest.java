package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {


    @Test
    @DisplayName("재고가 없는 경우")
    public void availableFoodAmount() {
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 2));

        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("양파", 1000));

        Customer customer = new Customer(buyList);

        assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(foodStand));
    }


    @Test
    @DisplayName("잔액이 부족한 경우")
    public void PaxtoxTest() {
        // 1. 테스트 환경 설정
        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 1));

        Customer customer = new Customer(buyList);
        customer.bring(new Basket());

        FoodStand foodStand = new FoodStand();
        // 고객의 잔액보다 비싼 상품
        foodStand.add(new Food("양파", 20001));

        Counter counter = new Counter();

        customer.pickFoods(foodStand);

        assertThrows(IllegalArgumentException.class, () -> {
            customer.payTox(counter);
        });
    }
}
