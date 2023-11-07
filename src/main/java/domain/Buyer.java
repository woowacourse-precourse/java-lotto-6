package domain;

import controller.Controller;

import static util.Util.inputPrice;

// 로또를 구입하는 대상에 관한 도메인
public class Buyer {
    private final int cost;

    public Buyer() {
        cost = inputPrice();
    }

    public int getPrice() {
        return cost;
    }
}