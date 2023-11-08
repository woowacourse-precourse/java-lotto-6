package lotto.domain.lotto;

import lotto.constants.lotto.LottoRule;
import lotto.exception.NotThousandUnitException;

public class PurchasePrice {

    private final Integer lottoPurchasePrice;

    private PurchasePrice(Integer purchasePrice) {
        validateThousandUnit(purchasePrice);
        this.lottoPurchasePrice = purchasePrice;
    }

    public static PurchasePrice from(Integer purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    private void validateThousandUnit(Integer purchasePrice) {
        if (isNotThousandUnit(purchasePrice)) {
            throw new NotThousandUnitException();
        }
    }

    private boolean isNotThousandUnit(Integer purchasePrice) {
        return purchasePrice % LottoRule.MONEY_UNIT != LottoRule.NOT_REMAIN;
    }

    public Integer getLottosAmount() {
        return lottoPurchasePrice / LottoRule.MONEY_UNIT;
    }
}
