package lotto.domain.lotto;

import static lotto.domain.lotto.LottoCondition.PRICE;

public class PurchasePrice {

    private static final String PURCHASE_PRICE_INDIVISIBLE_ERROR_MESSAGE = "구입 금액은 " + PRICE.getValue() + "원 단위로 입력해야 합니다.";
    private static final String PURCHASE_PRICE_ZERO_ERROR_MESSAGE = "구입 금액은 0원 이상이어야 합니다.";
    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice) {
        validateDivisible(purchasePrice);
        validateZero(purchasePrice);
    }

    private void validateDivisible(int purchasePrice) {
        if (purchasePrice % PRICE.getValue() != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_INDIVISIBLE_ERROR_MESSAGE);
        }
    }

    private void validateZero(int purchasePrice) {
        if(purchasePrice == 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ZERO_ERROR_MESSAGE);
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
