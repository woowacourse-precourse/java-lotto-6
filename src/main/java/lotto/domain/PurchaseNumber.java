package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.ErrorMessage.NEGATIVE_INTEGER;

import java.util.ArrayList;
import java.util.List;

public class PurchaseNumber {
    private static final int MONEY_UNIT = 1000;

    private final Integer number;

    public PurchaseNumber(Integer purchasePrice) {
        validateUnit(purchasePrice);
        validateRange(purchasePrice);
        this.number = convertToPurchaseNumber(purchasePrice);
    }

    private void validateRange(Integer purchasePrice) {
        if(purchasePrice.compareTo(0) < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER);
        }
    }

    private void validateUnit(Integer purchasePrice) {
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

    public List<Lotto> createLottoTickets() {
        return new ArrayList<>(number);
    }
}
