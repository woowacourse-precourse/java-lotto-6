package lotto.exception;

import lotto.model.Price;
import lotto.view.ErrorMessage;

import static lotto.exception.PriceCheck.*;

public class PriceException {
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
            ErrorMessage.priceZeroException();
            throw new IllegalArgumentException();
        }
    }

    public static void thousandPriceException(int price) throws IllegalArgumentException {
        if (!checkThousandPrice(price)) {
            ErrorMessage.notThousandPrice();
            throw new IllegalArgumentException();
        }
    }

}
