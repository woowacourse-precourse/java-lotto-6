package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ModelExceptionConstant;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int purchaseAmount) {
        validateIsDivideByLottoPrice(purchaseAmount);
        this.amount = purchaseAmount;
    }

    private void validateIsDivideByLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE.value() != 0) {
            throw new IllegalArgumentException(ModelExceptionConstant.NOT_DIVIDE_BY_LOTTO_PRICE.getText());
        }
    }

    public int getLottoCount() {
        return this.amount / LottoConstant.LOTTO_PRICE.value();
    }

    public int getAmount() {
        return this.amount;
    }

}
