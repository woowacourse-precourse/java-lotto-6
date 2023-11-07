package lotto.domain;

import java.util.regex.Pattern;

public class Price {
    private static final Integer LOTTO_PRICE = 1000;
    private final Integer price;
    public Price(String stringPurchasePrice) {
        validatePurchasePriceType(stringPurchasePrice);
        price = Integer.valueOf(stringPurchasePrice);
        validatePurchasePriceRange(price);
    }

    private void validatePurchasePriceType(String purchasePrice) {
        if (!Pattern.matches("[0-9]+", purchasePrice)) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자만 입력 가능합니다.");
        }
    }

    private void validatePurchasePriceRange(Integer purchasePrice) {
        if (purchasePrice % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    public Integer numberAvailableForPurchase() {
        return this.price / LOTTO_PRICE;
    }

    public long getPurchasePrice() {
        return price;
    }
}
