package lotto.domain;

import lotto.util.Parser;
import lotto.validator.InputNumberValidator;

public class Money {
    private final int money;

    public Money(String inputMoney) {
        validateOnlyNumber(inputMoney);
        this.money = toNumber(inputMoney);
    }

    private void validateOnlyNumber(String playerInput) {
        InputNumberValidator inputNumberValidator = new InputNumberValidator();
        inputNumberValidator.validate(playerInput);
    }

    private int toNumber(String playerInput) {
        Parser parser = new Parser();
        return parser.inputToNumber(playerInput);
    }

    public int getMoney() {
        return money;
    }
}
