package lotto.exception;

import lotto.model.Price;

import static lotto.view.ErrorMessage.notThousandPrice;
import static lotto.view.ErrorMessage.priceZeroException;

public class PriceException {
    private static final int standardPrice = 1000;
    public static Price priceException(int price) throws IllegalArgumentException{
        try {
            zeroPriceException(price);
            thousandPriceException(price);
            return new Price(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void zeroPriceException(int price) throws IllegalArgumentException{
        if (!checkZeroPrice(price)) {
            priceZeroException();
            throw new IllegalArgumentException();
        }
    }

    public static void thousandPriceException(int price) throws IllegalArgumentException {
        if (!checkThousandPrice(price)) {
            notThousandPrice();
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkZeroPrice(int price){
        if (price < standardPrice) {
            return false;
        }
        return true;
    }

    public static boolean checkThousandPrice(int price) {
        if (price % standardPrice != 0) {
            return false;
        }
        return true;
    }

}
