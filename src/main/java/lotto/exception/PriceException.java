package lotto.exception;

import lotto.model.Price;
import lotto.view.ErrorMessage;

import static lotto.exception.PriceCheck.*;

public class PriceException {

    private static String errorMessage;
    public static Price priceException(int price) throws IllegalArgumentException{
        zeroPriceException(price);
        thousandPriceException(price);
        return new Price(price);
    }

    public static void zeroPriceException(int price) throws IllegalArgumentException{
        if (!checkZeroPrice(price)) {
            errorMessage = ErrorMessage.PriceUnderThousand.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void thousandPriceException(int price) throws IllegalArgumentException {
        if (!checkThousandPrice(price)) {
            errorMessage = ErrorMessage.priceNotThousandRate.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
