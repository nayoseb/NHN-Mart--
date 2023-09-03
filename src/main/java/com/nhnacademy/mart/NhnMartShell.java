package com.nhnacademy.mart;

import java.util.Scanner;

public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        //item 리스트가 있는 구매목록 생성
        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        //구매목록을 가지고 있는 고객 객체 생성
        Customer yosebNa = new Customer(buyList);

        //고객의 장바구니 생성
        yosebNa.bring(mart.provideBasket());

        // 식품을 담는다.
        yosebNa.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        yosebNa.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        System.out.println("NHN 마트에 오신 것을 환영합니다.사고 싶은 물건을 입력해세요 (예 : 파 2 양파 2)");

        BuyList buyList = new BuyList();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            String[] parts = input.split(" ");
            for (int i = 0; i < parts.length; i += 2) {
                String foodname = parts[i];
                int foodamount = Integer.parseInt(parts[i + 1]);
                BuyList.Item item = new BuyList.Item(foodname, foodamount);
                buyList.add(item);
            }
        }
        return buyList;

    }

}