package lotto.controller;

import lotto.model.Price;

import static lotto.controller.InputConverter.convertPrice;
import static lotto.view.ErrorMessage.priceZeroException;

public class ExceptionController {

    public static Price checkPriceException(String inputPrice) throws IllegalArgumentException{
        try {
            int price = checkDigitException(inputPrice);
            return checkRightPrice(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Price checkRightPrice(int price) throws IllegalArgumentException{
        try {
            return new Price(price);
        } catch (IllegalArgumentException e) {
            priceZeroException();
            throw new IllegalArgumentException();
        }
    }

    public static int checkDigitException(String inputPrice) throws IllegalArgumentException {
        try {
            return convertPrice(inputPrice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
