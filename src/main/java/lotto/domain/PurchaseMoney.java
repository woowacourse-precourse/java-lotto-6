package lotto.domain;

import lotto.message.ConsoleMessage;

public class PurchaseMoney {
    private final int money;

    private PurchaseMoney(int money) {
        this.money = money;
    }

    public static PurchaseMoney of(int money) {
        validateThousandMoney(money);
        return new PurchaseMoney(money);
    }

    private static void validateThousandMoney(int money) {
        if (money%1000 != 0) {
            throw new IllegalArgumentException(ConsoleMessage.PURCHASE_MONEY_ERROR.getMessage());
        }
    }

    public int getPurchaseMoney() {
        return money;
    }

    public int buyCount() {
        return this.money/1000;
    }
}
