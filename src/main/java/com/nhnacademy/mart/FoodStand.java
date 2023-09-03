package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {


    private final ArrayList<Food> foods = new ArrayList<>();


    public int getAmountOf(String foodName) {
        int count = 0;
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                count++;
            }
        }
        return count;
    }

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구현
    public void remove(Food food) {
        foods.remove(food);
    }

    //음식이름으로 음식 찾기
    public Food findByfoodName(String foodName) {
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                return food;
            }
        }
        throw new IllegalArgumentException(foodName + " 음식이 매대에 없습니다.");
    }

}
