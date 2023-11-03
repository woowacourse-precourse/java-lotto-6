package lotto.domain;

import lotto.exception.NotThousandUnitException;

public class LottoPurchasePrice {

    private static final Integer UNIT = 1000;
    private static final Integer NOT_REMAIN = 0;

    private final Integer purchasePrice;

    public LottoPurchasePrice(Integer purchasePrice) {
        validateThousandUnit(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validateThousandUnit(Integer purchasePrice) {
        if (isNotThousandUnit(purchasePrice)) {
            throw new NotThousandUnitException();
        }
    }

    private boolean isNotThousandUnit(Integer purchasePrice) {
        return purchasePrice % UNIT != NOT_REMAIN;
    }
}
