package lotto.domain;

import static lotto.constants.Value.THOUSAND;

import lotto.validator.Validator;

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

        Validator.checkThousands(money);
    }

    public Integer countThousand() {
        return money / THOUSAND.get();
    }
}
