package lotto.domain;

import static lotto.constant.CustomerConst.*;

public class Customer {

    private int money;

    public Customer(String StringMoney) {
        int numberMoney = validateNumber(StringMoney);
        validateDigit(numberMoney);
        validateRange(numberMoney);
        this.money = numberMoney;
    }

    private int validateNumber(String money) {
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
