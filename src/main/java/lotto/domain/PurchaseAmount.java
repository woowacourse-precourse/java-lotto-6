package lotto.domain;

import lotto.utils.ValidateUtils;

import static lotto.utils.ValidateUtils.validateNumeric;

public class PurchaseAmount {
    private static final int MIN_PRICE = 1000;
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    private ValidateUtils validateUtils = new ValidateUtils();

    private PurchaseAmount(int purchaseAmount) {
        validateUtils.validateMinimum(purchaseAmount, MIN_PRICE);
        validateMultipleOfLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(String inputString) {
        validateNumeric(inputString);
        int purchaseAmount = Integer.parseInt(inputString);
        return new PurchaseAmount(purchaseAmount);
    }

    private void validateMultipleOfLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}

