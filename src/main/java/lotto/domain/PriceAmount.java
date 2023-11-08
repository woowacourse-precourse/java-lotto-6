package lotto.domain;

import org.assertj.core.api.ThrowableAssert;

public class PriceAmount {
    private static final int MIN_PRICE = 1000;
    private int priceAmount;

    public PriceAmount(int priceNumber) {
        if (!is1000Unit(priceNumber) || !isGreaterThanZero(priceNumber)) {
            throw new NumberFormatException("[ERROR] 금액은 1000단위로 입력해주세요.");
        }
        this.priceAmount = priceNumber;
    }

    private boolean isGreaterThanZero(int priceNumber) {
        return priceNumber > 0;
    }

    private boolean is1000Unit(int priceNumber) {
        return priceNumber % MIN_PRICE == 0;
    }

    public int getPurchaseNumber() {
        return priceAmount / MIN_PRICE;
    }

    public int getPriceAmount() {
        return priceAmount;
    }
}
