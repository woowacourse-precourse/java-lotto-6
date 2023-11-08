package lotto.model;

import lotto.exception.MoneyException.MoneyFormatException;
import lotto.exception.MoneyException.MoneyUnitException;
import lotto.exception.MoneyException.MoneyZeroException;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(String money) {
        this.money = validate(money);
    }

    private int validate(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new MoneyFormatException();
        }
        if (money == 0) {
            throw new MoneyZeroException();
        }
        if (money % LOTTO_PRICE != 0) {
            throw new MoneyUnitException();
        }
        return money;
    }

    public int calculateLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public double calculateYield(double totalPrizeMoney) {
        if(totalPrizeMoney == 0) {
            return 0.0;
        }
        double rate = ( totalPrizeMoney / (double) money) * 100.0;
        return Math.round(rate * 100.0) / 100.0;
    }
}
