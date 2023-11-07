package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.CustomerConst.*;

public class Customer {

    private int money;

    public Customer() {
        int inputMoney = input();
        validateDigit(inputMoney);
        validateRange(inputMoney);
        this.money = inputMoney;
    }

    private int input() {
        String money = Console.readLine();
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }

        return Integer.parseInt(money);
    }

    private void validateDigit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INDIVISIBLE);
        }

    }

    private void validateRange(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE);
        }

    }

    public int getCount() {
        return money / 1000;
    }


}
