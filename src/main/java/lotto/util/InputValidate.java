package lotto.util;

public class InputValidate {

    public void inputBonusRangeValidate(String input){
        inputBlankValidate(input);
        inputIsDigitValidate(input);
        int bonus = Integer.parseInt(input);
        if(bonus < 1 || bonus > 45){
            throw new IllegalArgumentException(Error.LOTTO_RANGE_ERROR.message());
        }
    }

    public void inputIsDigitValidate(String input){
        final String REGEX = "[0-9]+";
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException(Error.INPUT_DIGIT_ERROR.message());
        }
    }

    public void inputBlankValidate(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(Error.INPUT_BLANK_ERROR.message());
        }
    }
}
