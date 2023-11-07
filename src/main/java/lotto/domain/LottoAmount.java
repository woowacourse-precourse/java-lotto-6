package lotto.domain;

import lotto.view.Message;

import static lotto.view.Constants.*;
import static lotto.view.Message.*;

public class LottoAmount {
    private final int amount;

    public LottoAmount(String amount) {
        this.amount = checkAmount(amount);
    }

    public int calcLottoNum() {
        return amount / LOTTO_PRICE;
    }

    private int checkAmount(String amount) {
        int num = checkNumber(amount);
        checkPositive(num);
        checkFormat(num);
        return num;

    }

    private static int checkNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            Message.typeException();
            throw new IllegalArgumentException();
        }
    }


    private static void checkPositive(int amount) {
        if (amount <= 0) {
            Message.rangeException();
            throw new IllegalArgumentException();
        }
    }

    private void checkFormat(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            Message.numberFormatException();
            throw new IllegalArgumentException();

        }
    }

}
