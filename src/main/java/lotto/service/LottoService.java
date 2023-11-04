package lotto.service;

import static lotto.constant.LottoSetting.*;

public class LottoService {
    public void purchase(String purchaseAmountInput) {
        Integer purchaseAmount = validatePurchaseAmount(purchaseAmountInput);
    }

    private Integer validatePurchaseAmount(String purchaseAmountInput) {
        Integer purchaseAmount = validateNumeric(purchaseAmountInput);
        purchaseAmount = validateDivisible(purchaseAmount);
        return purchaseAmount;
    }

    private Integer validateNumeric(String purchaseAmountInput) {
        try {
            return Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private Integer validateDivisible(Integer purchaseAmount) {
        if (purchaseAmount % DIVISOR.getValue() != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount / DIVISOR.getValue();
    }
}
