package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.PriceValidator;

public class PurchasePrice {
    private final int price;

    private PurchasePrice(int price) {
        PriceValidator.validate(price);
        this.price = price;
    }

    public static PurchasePrice from(String input) {
        return new PurchasePrice(Convertor.convertStringToInt(input));
    }

    public int getPrice() {
        return price;
    }
}
