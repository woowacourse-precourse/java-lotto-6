package lotto.domain;

public class PurchaseMoney {
    private final int money;

    private PurchaseMoney(int money) {
        this.money = money;
    }

    public static PurchaseMoney of(int money) {
        return new PurchaseMoney(money);
    }
}
