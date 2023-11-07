package lotto.model;

import lotto.constant.ErrorDetail;

public class MoneyToBuy {
    private final Integer value;
    private static final Integer costOfLotto = 1000;

    public MoneyToBuy(Integer value) {
        validate(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validate(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorDetail.NEGATIVE_MONEY_ERROR.getMessage());
        } else if (value % costOfLotto != 0) {
            throw new IllegalArgumentException(ErrorDetail.WRONG_MONEY_ERROR.getMessage(costOfLotto));
        }
    }

    public Integer getLottosNumber() {
        return value / costOfLotto;
    }
}
