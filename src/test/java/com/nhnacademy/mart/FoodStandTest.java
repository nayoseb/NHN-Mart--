package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodStandTest {
    @Test
    public void FindByFoodNameTest() {
        FoodStand foodStand = new FoodStand();

        assertThrows(IllegalArgumentException.class, () -> {
            foodStand.findByfoodName("양파");
        });
    }

}