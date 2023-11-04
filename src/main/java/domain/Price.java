package domain;

import domain.validator.PriceUnitValidator;
import util.ConstantOfLotto;

public class Price {

    private int price;
    private final PriceUnitValidator priceUnitValidator = new PriceUnitValidator();
    public Price(int price) {
        priceUnitValidator.checkPriceUnit(price);
        this.price = price;
    }

    public int numOfLotto() {
        return price / ConstantOfLotto.priceOfLotto;
    }
}
