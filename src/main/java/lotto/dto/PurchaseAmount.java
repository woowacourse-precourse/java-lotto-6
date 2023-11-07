package lotto.dto;

import static lotto.constants.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.ErrorCode.NOT_DIVIDED;
import static lotto.constants.ErrorCode.NOT_INTEGER;
import static lotto.constants.LottoRule.MAX_PRICE;
import static lotto.constants.LottoRule.MIN_PRICE;
import static lotto.constants.LottoRule.UNIT_PRICE;

public class PurchaseAmount {
    private int paidMoney;
    private int quantity;

    private PurchaseAmount(String input) {
        validatePurchaseAmount(input);
        this.paidMoney = convertToInt(input);
        this.quantity = getUnitAmount(input);
    }

    public static PurchaseAmount from(String input) {
        return new PurchaseAmount(input);
    }

    private int getUnitAmount(String input) {
        return convertToInt(input) / UNIT_PRICE.getValue();
    }

    private void validatePurchaseAmount(String input) {
        isInteger(input);
        int paidMoney = convertToInt(input);
        validateDividedBy(paidMoney);
        validateRange(paidMoney);
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private void isInteger(String input) {
        try {
            convertToInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    private void validateDividedBy(int paidMoney) {
        if (paidMoney % UNIT_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED.getMessage());
        }
    }

    private void validateRange(int paidMoney) {
        if (paidMoney > MAX_PRICE.getValue() || paidMoney <= MIN_PRICE.getValue()) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    public int getQuantity() {
        return quantity;
    }
}
