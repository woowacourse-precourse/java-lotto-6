package lotto.Model;

import lotto.Util.Rule;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue)  {
        if (inputValue == Rule.ZERO) {
            throw new IllegalArgumentException(Rule.MONEYZERO_ERROR);
        }
    }

    private void validateDivideMoney(int inputValue)  {
        if (inputValue % Rule.THOUSAND != Rule.ZERO ) {
            throw new IllegalArgumentException(Rule.DIVIDEMONEY_ERROR);
        }
    }
    public int getLotto() {
        return money / Rule.THOUSAND ;
    }

}
