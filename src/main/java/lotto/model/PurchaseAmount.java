package lotto.model;

import lotto.constant.Constants;
import lotto.message.ExceptionMessage;

public class PurchaseAmount {
    private static final String NUMBER_SEPARATOR = ",";
    private static final String EMPTY = "";
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
        IsNotEmpty(price);
        IsInRange(price);
        IsMultipleOfUnit(convertStringToInt(price));
    }

    private void IsNotEmpty(String price) {
        if(price == null || price.isBlank()){
            ExceptionMessage.INPUT_EMPTY_STRING_MESSAGE.throwException();
        }
    }

    private void IsInRange(String price) {
        if(!price.chars().allMatch(Character::isDigit)){
            ExceptionMessage.INPUT_ZERO_OR_LESS_MESSAGE.throwException();
        }
    }

    private void IsMultipleOfUnit(int price) {
        int purchaseAmountUnit = Constants.PURCHASE_AMOUNT_UNIT.getValue();
        if (price % purchaseAmountUnit != 0) {
            ExceptionMessage.INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE.throwException(purchaseAmountUnit);
        }
    }

    private String removeSeparator(String price) {
        return price.replace(NUMBER_SEPARATOR, EMPTY);
    }

    private int convertStringToInt(String price) {
        return Integer.parseInt(price);
    }
}
