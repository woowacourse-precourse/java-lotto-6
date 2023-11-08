package lotto.domain;

import lotto.constant.LottoNumber;
import lotto.validator.MainValidator;

public class Buyer {
    private final int purchaseAmount;
    private final MainValidator mainValidator = new MainValidator();

    public Buyer(String purchaseAmount) {
        mainValidator.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumberOfLotto() {
        return purchaseAmount / LottoNumber.PRICE_PER_LOTTO.getLottoNumber();
    }
}
