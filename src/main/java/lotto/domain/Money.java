package lotto.domain;

import lotto.view.InputView;

public class Money {
    public static int amount;
    public static final int DIVIDE_CONDITION = 1000;

    public Money() {
        validate();
    }

    public int trial() {
        return amount / DIVIDE_CONDITION;
    }

    public void validate() {
        try {
            amount = InputView.inputMoney();
            validateDivide();
            validateNegative();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            validate();
        }
    }

    public void validateDivide() {
        if (amount % DIVIDE_CONDITION != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public void validateNegative() {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 양수 금액을 입력해주세요.");
        }
    }
}
