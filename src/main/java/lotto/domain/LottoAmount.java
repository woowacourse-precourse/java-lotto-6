package lotto.domain;

import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;

public class LottoAmount {
    private final int money;

    public LottoAmount(String money) {
        this.money = validatePurchasePrice(money);
    }

    private int validatePurchasePrice(String money) {

    }

    private void checkValidInteger(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_MONEY.getMessage());
        }
    }
}
