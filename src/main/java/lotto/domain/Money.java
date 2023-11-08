package lotto.domain;

import lotto.validator.Validate;
import lotto.view.ErrorMessage;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private static final Integer LOTTOPRICE = 1000;
    private final int money;

    public Money(Integer money){
        validate(money);
        this.money = money;
    }
    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR.getMessage());
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDE_ERRO.getMessage());
        }
    }

    public int countMoney(){
        return money / LOTTOPRICE;
    }
}
