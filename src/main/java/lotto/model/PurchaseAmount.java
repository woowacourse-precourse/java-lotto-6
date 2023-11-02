package lotto.model;

import lotto.message.ExceptionMessage;

public class PurchaseAmount {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final String NUMBER_SEPARATOR = ",";
    private static final String EMPTY = "";
    private final int price;

    public PurchaseAmount(String price) {
        price = removeSeparator(price);
        validate(price);
        this.price = convertStringToInt(price);
    }

    private void validate(String price) {
        IsNumber(price);
        IsPositive(convertStringToInt(price));
        IsThousandUnits(convertStringToInt(price));
    }

    private String removeSeparator(String price) {
        return price.replace(NUMBER_SEPARATOR, EMPTY);
    }

    private void IsNumber(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.throwException();
        }
    }

    private void IsPositive(int price) {
        if (price < 0) {
            ExceptionMessage.INPUT_UNDER_ZERO_MESSAGE.throwException();
        }
    }

    private void IsThousandUnits(int price) {
        if (price % PURCHASE_AMOUNT_UNIT != 0) {
            ExceptionMessage.INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE.throwException(String.valueOf(PURCHASE_AMOUNT_UNIT));
        }
    }

    private int convertStringToInt(String price) {
        return Integer.parseInt(price);
    }
}
