package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static lotto.constant.LottoNumber.ZERO;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_MONEY;
import static lotto.constant.message.ErrorMessage.NOT_PURCHASE_UNIT;

public class LottoAmount {
    private final int money;

    public LottoAmount(String money) {
        this.money = validatePurchasePrice(money);
    }

    private int validatePurchasePrice(String money) {
        checkValidInteger(money);
        checkDivideByThousand(money);

        return Integer.parseInt(money);
    }

    private void checkValidInteger(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_MONEY.getMessage());
        }
    }

    private void checkDivideByThousand(String money) {
        if (Integer.parseInt(money) % PURCHASE_UNIT.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(NOT_PURCHASE_UNIT.getMessage());
        }
    }
}
