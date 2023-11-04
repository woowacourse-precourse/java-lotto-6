package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;

public class PurchaseNumber {
    private static final int MONEY_UNIT = 1000;

    private final Integer number;

    public PurchaseNumber(Integer purchasePrice) {
        validate(purchasePrice);
        this.number = convertToPurchaseNumber(purchasePrice);
    }

    private void validate(Integer purchasePrice) {
        if(purchasePrice % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

    private Integer convertToPurchaseNumber(Integer purchasePrice) {
        return purchasePrice / MONEY_UNIT;
    }

    public boolean lessThanPurchaseNumber(Integer number) {
        if(number.compareTo(this.number) < 0) {
            return true;
        }
        return false;
    }
}
