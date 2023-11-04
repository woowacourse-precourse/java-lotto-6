package domain;

import domain.validator.PriceUnitValidator;
import util.PriceOfLotto;

public class Price {

    private int price;
    private final PriceUnitValidator priceUnitValidator = new PriceUnitValidator();
    public Price(int price) {
        priceUnitValidator.checkPriceUnit(price);
        this.price = price;
    }

    public int numOfLotto() {
        return price / PriceOfLotto.priceOfLotto;
    }
}
