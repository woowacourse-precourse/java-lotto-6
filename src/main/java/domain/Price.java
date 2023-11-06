package domain;

import domain.validator.PriceValidator;
import util.ConstantOfLotto;

public class Price {

    private int price;
    private final PriceValidator priceUnitValidator = new PriceValidator();
    public Price(int price) {
        priceUnitValidator.checkPriceValidation(price);
        this.price = price;
    }

    public int numOfLotto() {
        return price / ConstantOfLotto.priceOfLotto;
    }
}
