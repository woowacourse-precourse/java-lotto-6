package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ModelExceptionConstant;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateIsDivideByLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateIsDivideByLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE.value() != 0) {
            throw new IllegalArgumentException(ModelExceptionConstant.NOT_DIVIDE_BY_LOTTO_PRICE.getText());
        }
    }
}
