package lotto.domain;

import lotto.enums.LottoValue;
import lotto.util.Convertor;
import lotto.validation.PriceValidator;

public class PurchasePrice {
    private final long price;

    private PurchasePrice(long price) {
        PriceValidator.validate(price);
        this.price = price;
    }

    public static PurchasePrice from(String input) {
        return new PurchasePrice(Convertor.convertStringToLong(input));
    }

    public int calculatePurchaseCount() {
        return (int) (price / LottoValue.PRICE_PER_LOTTO.getValue());
    }
}
