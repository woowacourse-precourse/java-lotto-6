package lotto.exception;

import lotto.model.Price;

import static lotto.view.ErrorMessage.priceZeroException;

public class PriceException {
    private static final int minPrice = 1000;
    public static Price checkPriceException(int price) throws IllegalArgumentException{
        try {
            checkZeroPriceException(price);
            return new Price(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkZeroPriceException(int price) throws IllegalArgumentException{
        if (!checkZeroPrice(price)) {
            priceZeroException();
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkZeroPrice(int price) throws IllegalArgumentException{
        if (price < minPrice) {
            return false;
        }
        return true;
    }

}
