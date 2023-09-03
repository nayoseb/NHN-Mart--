package com.nhnacademy.mart;

public class Counter {


    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public int pay(Basket basket) {
        int totalCost = 0;
        //basket 안에 있는 foods를 돌면서 가격을 구하는 메서드
        for (Food food : basket.getFoods()) {
            totalCost += food.getPrice();
        }
        return totalCost;
    }


}
