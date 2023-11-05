package lotto.util;

import lotto.config.LottoConfig;
import lotto.config.ValidatorConfig;

public class Validation {

    private static final int ZERO = 0;

    public static void validateAmount(String input){
        validateInteger(input);
        validatePurchaseUnit(Integer.parseInt(input));
    }

    private static void validatePurchaseUnit(int input){
        if(!(input % LottoConfig.LOTTO_LEAST_AMOUNT.getValue() == ZERO)){
            throw new IllegalArgumentException(ValidatorConfig.PURCHASE_UNIT_ERROR.getMessage());
        }
    }

    public static void validateInteger(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(ValidatorConfig.STRING_TO_INTEGER_ERROR.getMessage());
        }
    }

}
