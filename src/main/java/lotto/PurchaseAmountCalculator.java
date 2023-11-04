package lotto;

import static lotto.utils.validator.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.validator.ErrorMessageConstants.NUMBER_FORMAT_ERROR_MESSAGE;
import static lotto.utils.validator.ErrorMessageConstants.NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.utils.validator.ErrorMessageConstants.NUMBER_UNIT_ERROR_MESSAGE;

public class PurchaseAmountCalculator {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private static final int MAXIMUM_PURCHASE_AMOUNT = 100000;


    public int getTicketQuantity(String inputValue){
        int purchaseAmount = convertStringToInt(inputValue);
        validate(purchaseAmount);
        return purchaseAmount/LOTTO_TICKET_PRICE;
    }


    private int convertStringToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public void validate(int purchaseAmount) {
        validateUnit(purchaseAmount);
        validatePurchaseRange(purchaseAmount);
    }

    private void validatePurchaseRange(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT || purchaseAmount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+NUMBER_UNIT_ERROR_MESSAGE);
        }
    }
}
