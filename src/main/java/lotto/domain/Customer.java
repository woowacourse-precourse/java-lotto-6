package lotto.domain;

import static lotto.constant.CustomerConst.*;

public class Customer {

    private final Long money;

    public Customer(String StringMoney) {
        Long numberMoney = validateNumber(StringMoney);
        validateDigit(numberMoney);
        validateRange(numberMoney);
        this.money = numberMoney;
    }

    private Long validateNumber(String money) {
        try {
            Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }

        return Long.parseLong(money);
    }

    private void validateDigit(Long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INDIVISIBLE);
        }

    }

    private void validateRange(Long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE);
        }

    }

    public Long getCount() {
        return money / 1000;
    }


}
