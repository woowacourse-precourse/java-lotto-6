package domain;

import domain.validator.PriceUnitValidator;

public class Price {

    private int price;
    private final PriceUnitValidator priceUnitValidator = new PriceUnitValidator();
    Price(int price) {

        this.price = price;
    }
}
