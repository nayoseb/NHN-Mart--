package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
    private int money = 20000;
    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;


    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }


    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        for (BuyList.Item item : buyList.getItems()) {
            String foodName = item.getName();
            int buyAmonut = item.getAmount();

            int totalAmount = foodStand.getAmountOf(foodName);

            if (totalAmount < buyAmonut) {
                throw new IllegalArgumentException("재고가 부족합니다.");

            }

            for (int i = 0; i < buyAmonut; i++) {
                Food food = foodStand.findByfoodName(foodName);
                basket.add(food);
                foodStand.remove(food);
            }
        }


        // TODO payTox 메서드 구현


    }

    public void payTox(Counter counter) {
        int totalCost = counter.pay(basket);

        if (money < totalCost) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        money = money - totalCost;

            System.out.println("총 가격은 " + totalCost + "원 입니다.");
            System.out.println("고객님 결제 후 잔액 : " + money);

    }

}
