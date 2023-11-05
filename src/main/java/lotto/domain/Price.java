package lotto.domain;

import static lotto.util.ExceptionEnum.INVALID_PURCHASE_PRICE_UNIT;

public class Price{

    private final int purchasePrice;
    private static final int UNIT = 1000;

    public Price(int purchasePrice){
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice){
        throwIfInvalidPurchasePriceUnit(purchasePrice);
    }

    private void throwIfInvalidPurchasePriceUnit(int purchasePrice){
        if (purchasePrice % UNIT != 0){
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE_UNIT.getMessage());
        }
    }

    public int getLottoCount(){
        return this.purchasePrice/UNIT;
    }

    double calculateEarningRate(int winningPrice){
        return -1;
    }

}
