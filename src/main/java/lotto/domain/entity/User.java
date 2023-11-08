package lotto.domain.entity;

import lotto.exception.ExceptionCode;

public class User {

    public static final int PRICE_PER_LOTTO = 1000;
    private final Lottos lottos;
    private final Long purchasePrice;

    public User(final Lottos lottos, final Long purchasePrice) {
        validateAmount(purchasePrice);
        validateSign(purchasePrice);
        this.lottos = lottos;
        this.purchasePrice = purchasePrice;
    }

    private void validateSign(Long purchasePrice) {
        if (purchasePrice < 0) {
            throw new IllegalArgumentException(
                    ExceptionCode.UNSIGNED_PURCHASE_PRICE.getDescription()
            );
        }
    }

    /**
     * 1000원 단위의 금액. 0을 허용한다.
     * @param purchasePrice
     */
    private void validateAmount(final Long purchasePrice) {
        if (purchasePrice % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(
                    ExceptionCode.AMOUNT_PURCHASE_PRICE.getDescription()
            );
        }
    }

    public static Long calculatePurchaseAmount(final Long purchasePrice) {
        return purchasePrice / PRICE_PER_LOTTO;
    }

    public float calculateEarningRate(final Long totalPrize) {
        if (purchasePrice == 0) {
            return purchasePrice;
        }
        return (float) (totalPrize * 100) / this.purchasePrice;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
