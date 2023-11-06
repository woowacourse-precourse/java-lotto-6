package domain;

import domain.validator.PriceValidator;
import util.ConstantOfLotto;

public class Price {

    private int price;
    private final PriceValidator priceValidator = new PriceValidator();
    public Price(int price) {
        priceValidator.checkPriceValidation(price);
        this.price = price;
    }

    public int numOfLotto() {
        return price / ConstantOfLotto.PRICE_OF_LOTTO;
    }
}
