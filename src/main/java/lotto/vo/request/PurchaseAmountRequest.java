package lotto.vo.request;

import static lotto.constants.ErrorMessage.NOT_INTEGER;

import lotto.domain.PurchaseNumber;

public class PurchaseAmountRequest {
    private final Integer price;

    public PurchaseAmountRequest(String input) {
        this.price = validateInteger(input);
    }

    private Integer validateInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    public PurchaseNumber calculatePurchaseNumber() {
        return new PurchaseNumber(price);
    }
}
