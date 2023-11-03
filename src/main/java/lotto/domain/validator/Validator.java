package lotto.domain.validator;

import lotto.constant.RegularConstant;
import lotto.enums.ErrorMessage;
import lotto.constant.PatternConstant;

import java.util.regex.Matcher;

public class Validator {

    public static void validateExistValue(String inputValue) {
        String val = inputValue.trim();
        if(val.equals("")){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NON_EXISTENT_VALUE.getMessage());
        }
    }

    public static int validateNumericInput(String inputValue) {
        Matcher matcher = PatternConstant.NUMBER_PATTERN.matcher(inputValue);

        if(!matcher.matches()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMERIC_VALUE.getMessage());
        }

        return Integer.parseInt(inputValue);
    }

    public static int validateDivisibleBy1000(int inputMoney) {
        if(inputMoney % RegularConstant.UNIT_AMOUNT != 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INDIVISIBLE_BY_1000.getMessage());
        }

        return inputMoney / RegularConstant.UNIT_AMOUNT;
    }
}
