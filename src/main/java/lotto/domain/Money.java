package lotto.domain;

import lotto.view.InputView;

public class Money {
    public final int amount;
    public static final int DIVIDE_CONDITION = 1000;
    public final int trial;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
        trial = amount / DIVIDE_CONDITION;
    }

    public void validate(int amount) {
        try {
            validateDivide(amount);
            validateNegative(amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            new Money(InputView.inputMoney());
        }
    }

    public void validateDivide(int amount) {
        if (amount % DIVIDE_CONDITION != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public void validateNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 양수 금액을 입력해주세요.");
        }
    }
}
