package lotto.model;

import java.util.Arrays;

public enum PriceMoney {

    NOTHING(0, 0),
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int count;
    private final int price;

    PriceMoney(Integer count, Integer price) {
        this.count = count;
        this.price = price;
    }

    public static PriceMoney of(int count, boolean hasbonusNumber) {
        if (count == 5 && hasbonusNumber == true) {
            return SECOND;
        }
        return Arrays.stream(PriceMoney.values())
                .filter(rank -> rank.count == count)
                .findAny()
                .orElse(NOTHING);
    }

    public int getPrice() {
        return price;
    }
}
