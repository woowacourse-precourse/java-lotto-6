package lotto.exception;

import lotto.model.Price;

import static lotto.view.ErrorMessage.priceZeroException;

public class PriceException {
    public static Price checkPriceException(int price) throws IllegalArgumentException{
        try {
            checkZeroPriceException(price);
            return new Price(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkZeroPriceException(int price) throws IllegalArgumentException{
        try {
            Price.checkZeroPrice(price);
        } catch (IllegalArgumentException e) {
            priceZeroException();
            throw new IllegalArgumentException();
        }
    }

}
