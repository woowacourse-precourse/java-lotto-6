package lotto.util;

public class InputValidate {

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
