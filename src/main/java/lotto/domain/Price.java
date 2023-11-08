package lotto.domain;

import lotto.exception.NotValidGivenPriceException;

public class Price {

    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validate(int price) {
        validatePriceAndThrowException(price);
    }

    public void validatePriceAndThrowException(int price) throws IllegalArgumentException {
        if (price == 0 || price % LottoProperty.LOTTO_PRICE_UNIT.getNumber() != 0) {
            throw new NotValidGivenPriceException();
        }
    }
}
