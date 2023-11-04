package lotto.domain;

import lotto.Validator;

public class Money {
    private Integer money;

    public Money(String userInput) {
        checkMoney(userInput);
    }

    private void checkMoney(String userInput) {
        Validator.checkNumber(userInput);
        money = Integer.parseInt(userInput);

        Validator.checkPositiveNumber(money);
        Validator.checkZero(userInput);

        Validator.checkRemainder(money);
    }

    public Integer countThousand() {
        return money / 1000;
    }
}
