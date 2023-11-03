package lotto.util;

import java.util.Arrays;

import static lotto.util.ErrorMessage.*;

public class Validator {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static void validateAmount(String amountInput){
        validateNumericInput(amountInput);
        validateLottoPurchaseAmount(amountInput);
    }

    private static void validateNumericInput(String input) {
        if(!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateLottoPurchaseAmount(String amountInput){
        int amount = Integer.parseInt(amountInput);
        if(amount%LOTTO_PRICE != 0 ){
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static void validateWinningNumber(String winningNumberStr){
        String[] winningNumbers = winningNumberStr.split(",");
        Arrays.stream(winningNumbers).forEach((number)->{
            validateNumericInput(number);
            validateNumberInRange(Integer.parseInt(number));
        });
    }



    private static void validateNumberInRange(int number){
        if(number>LOTTO_LAST_NUMBER||number<LOTTO_START_NUMBER){
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }


}
