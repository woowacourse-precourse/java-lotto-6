package lotto.domain;

import lotto.validate.InputValidate;
import lotto.validate.MoneyValidate;

public class Money {

    private static final int UNIT = 1_000;
    private int givenMoney;
    private final MoneyValidate moneyValidate;
    private final InputValidate inputValidate;

    public Money() {
        this.moneyValidate = new MoneyValidate();
        this.inputValidate = new InputValidate();
    }

    public void inputMoney(String input) {
        Integer inputNumber = inputValidate.inputSingleNumberValidate(input);
        this.givenMoney = moneyValidate.checkMoneyValidate(inputNumber, UNIT);
    }

    public int countQuantity() {
        return (givenMoney / UNIT);
    }

    public double calculateIncomeRate(Integer prize) {
        return (double) prize / givenMoney * (100);
    }
}
