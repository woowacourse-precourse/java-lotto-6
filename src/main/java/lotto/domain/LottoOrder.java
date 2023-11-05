package lotto.domain;

import lotto.exception.ExceptionMessage;

public class LottoOrder {
    private final static int BASIC_LOTTO_PRICE = 1000;
    private final Long purchasePrice;
    private final PurchaseLotto purchaseLotto;

    public LottoOrder(Long purchasePrice, PurchaseLotto purchaseLotto) {
        validatePrice(purchasePrice);

        this.purchasePrice = purchasePrice;
        this.purchaseLotto = purchaseLotto;
    }

    private void validatePrice(Long purchasePrice) {
        if (purchasePrice == 0 || Math.floorMod(purchasePrice, BASIC_LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_PRICE.getDesc());
        }
    }

}
