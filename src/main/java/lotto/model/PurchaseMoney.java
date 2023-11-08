package lotto.model;

import static lotto.util.Constants.DIVIDE_PRICE;
import static lotto.util.Constants.MIN_PRICE;

import lotto.exception.ErrorType;

public class PurchaseMoney {

    private int purchaseMoney;

    public PurchaseMoney(int purchaseMoney) {
        validate(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseAmount() {
        return purchaseMoney / DIVIDE_PRICE;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    private void validate(int purchaseMoney) {
        validateMinPrice(purchaseMoney);
        validateAmount(purchaseMoney);
    }

    private void validateMinPrice(int purchaseMoney) {
        if (purchaseMoney < MIN_PRICE) {
            throw new IllegalArgumentException(ErrorType.INVALID_MIN_PRICE.getMessage());
        }
    }

    private void validateAmount(int purchaseMoney) {
        if (isDivisible(purchaseMoney)) {
            throw new IllegalArgumentException(ErrorType.INVALID_DIVIDE_PRICE.getMessage());
        }
    }

    private boolean isDivisible(int purchaseMoney) {
        return purchaseMoney % DIVIDE_PRICE != 0;
    }

}
