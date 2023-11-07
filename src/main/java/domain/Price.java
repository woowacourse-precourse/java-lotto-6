package domain;

import domain.validator.PriceValidator;
import util.ConstantOfLotto;

public class Price {
    private final int price;

    public Price(int price) {
        PriceValidator priceValidator = new PriceValidator();
        priceValidator.checkPriceValidation(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int numOfLotto() {
        return price / ConstantOfLotto.PRICE_OF_LOTTO;
    }
}
