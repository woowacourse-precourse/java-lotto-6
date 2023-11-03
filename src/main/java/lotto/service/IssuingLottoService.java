package lotto.service;

import lotto.model.PurchaseAmount;

public class IssuingLottoService {
    public PurchaseAmount createPurchaseAmount(String inputPurchaseAmount) {
        validatePurchaseAmount(inputPurchaseAmount);

        return new PurchaseAmount(Integer.parseInt(inputPurchaseAmount));
    }

    private void validatePurchaseAmount(String inputPurchaseAmount) {
        isNumber(inputPurchaseAmount);
    }

    private void isNumber(String inputPurchaseAmount) {
        try {
            Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력이 가능합니다.");
        }
    }
}
