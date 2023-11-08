package lotto.domain;

import static lotto.constant.ExceptionMessages.*;
import static lotto.constant.SystemNumbers.TICKET_PRICE;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount validate(int amount) {
        validateRange(amount);
        validateUnit(amount);
        return new PurchaseAmount(amount);
    }

    private static void validateRange(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_ACCOUNT_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateUnit(int amount) {
        if ((amount % TICKET_PRICE.getNumber()) != 0) {
            throw new IllegalArgumentException(PURCHASE_ACCOUNT_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    public int calculateNumberOfLottos() {
        return amount / TICKET_PRICE.getNumber();
    }

    public int getPurchaseAmount() {
        return amount;
    }

}
