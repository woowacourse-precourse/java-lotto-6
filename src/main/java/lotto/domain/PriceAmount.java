package lotto.domain;

import org.assertj.core.api.ThrowableAssert;

public class PriceAmount {
    private int priceAmount;

    public PriceAmount(int priceNumber) {
        if (!is1000Unit(priceNumber) || !isGreaterThanZero(priceNumber)) {
            throw new NumberFormatException("[ERROR] 금액은 1000단위로 입력해주세요.");
        }
        this.priceAmount = priceNumber;
    }

    private static boolean isGreaterThanZero(int priceNumber) {
        return priceNumber > 0;
    }

    private static boolean is1000Unit(int priceNumber) {
        return priceNumber % 1000 == 0;
    }

    public int getPurchaseNumber() {
        return priceAmount / 1000;
    }

    public int getPriceAmount() {
        return priceAmount;
    }
}
