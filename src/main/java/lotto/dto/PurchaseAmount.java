package lotto.dto;

import static lotto.constants.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.ErrorCode.NOT_DIVIDED;
import static lotto.constants.LottoRule.MAX_PRICE;
import static lotto.constants.LottoRule.MIN_PRICE;
import static lotto.constants.LottoRule.UNIT_PRICE;

import lotto.validator.InputValidator;

public class PurchaseAmount {
    private int paidMoney;
    private int quantity;

    private PurchaseAmount(String input) {
        validate(input);
        this.paidMoney = convertToInt(input);
        this.quantity = getUnitAmount(input);
    }

    public static PurchaseAmount from(String input) {
        return new PurchaseAmount(input);
    }

    private void validate(String input) {
        InputValidator.validateIsInteger(input);
        int paidMoney = convertToInt(input);
        validateDividedBy(paidMoney);
        validateRange(paidMoney);
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
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

    private int getUnitAmount(String input) {
        return convertToInt(input) / UNIT_PRICE.getValue();
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    public int getQuantity() {
        return quantity;
    }
}
