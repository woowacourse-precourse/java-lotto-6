package lotto.domain;

import lotto.util.Parser;
import lotto.validator.OnlyNumberValidator;
import lotto.validator.InputUnitValidator;

public class Money {
    private final Integer money;

    public Money(String playerInput) {
        validateOnlyNumber(playerInput);
        int inputMoney = toNumber(playerInput);
        validateNumberUnit(inputMoney);
        this.money = inputMoney;
    }

    private void validateOnlyNumber(String playerInput) {
        OnlyNumberValidator onlyNumberValidator = new OnlyNumberValidator();
        onlyNumberValidator.validate(playerInput);
    }

    private void validateNumberUnit(int inputMoney) {
        InputUnitValidator inputUnitValidator = new InputUnitValidator();
        inputUnitValidator.validate(inputMoney);
    }

    private int toNumber(String playerInput) {
        Parser parser = new Parser();
        return parser.inputToNumber(playerInput);
    }

    public int getMoney() {
        return money;
    }
}
