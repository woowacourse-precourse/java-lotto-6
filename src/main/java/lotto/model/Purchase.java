package lotto.model;

import lotto.view.ErrorConstants;

public class Purchase {
    private static final Integer MAX_PRICE = 100_000;
    private Integer money;

    public Purchase(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money) {
        if (money % 1000 != 0 || money == 0 || money > MAX_PRICE) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_MONEY_ERROR);
        }
    }

    public Integer getNumberOfPurchases() {
        return money / 1000;
    }
}
