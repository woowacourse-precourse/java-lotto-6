package lotto.util;

import static lotto.util.ErrorMessage.INVALID_NUMBER_FORMAT;
import static lotto.util.ErrorMessage.INVALID_PURCHASE_AMOUNT;

public class Validator {
    public static final int LOTTO_PRICE = 1000;
    public static void validateAmount(String amountInput){
        validateNumericInput(amountInput);
        validateLottoPurchaseAmount(amountInput);
    }

    private static void validateNumericInput(String amountInput) {
        if(!amountInput.matches("^[0-9]+$")){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateLottoPurchaseAmount(String amountInput){
        int amount = Integer.parseInt(amountInput);
        if(amount%LOTTO_PRICE != 0 ){
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }



}
