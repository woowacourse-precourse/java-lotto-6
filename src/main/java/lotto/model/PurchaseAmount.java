package lotto.model;

import lotto.constant.IntConstants;
import lotto.constant.StringConstants;
import lotto.message.ExceptionMessage;

public class PurchaseAmount {
    private final int price;

    public PurchaseAmount(String price) {
        price = removeSeparator(price);
        validate(price);
        this.price = convertStringToInt(price);
    }

    public int getPurchaseAmount() {
        return price;
    }

    private void validate(String price) {
        IsNumber(price);
        IsZeroOrOver(convertStringToInt(price));
        IsMultipleOfUnit(convertStringToInt(price));
    }

    private void IsNumber(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException exception) {
            ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.throwException();
        }
    }

    private void IsZeroOrOver(int price) {
        if (price < 0) {
            ExceptionMessage.INPUT_LESS_THAN_ZERO_MESSAGE.throwException();
        }
    }

    private void IsMultipleOfUnit(int price) {
        int purchaseAmountUnit = IntConstants.PURCHASE_AMOUNT_UNIT.getValue();
        if (price % purchaseAmountUnit != 0) {
            ExceptionMessage.INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE.throwException(purchaseAmountUnit);
        }
    }

    private String removeSeparator(String price) {
        String NUMBER_SEPARATOR = StringConstants.NUMBER_SEPARATOR.getValue();
        String EMPTY = StringConstants.EMPTY.getValue();
        return price.replace(NUMBER_SEPARATOR, EMPTY);
    }

    private int convertStringToInt(String price) {
        return Integer.parseInt(price);
    }
}
