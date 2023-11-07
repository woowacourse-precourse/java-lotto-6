package validators;

import constants.ErrorCodeConstant;

public class CommonValidator {

    public static void isOnlyNumber(String number){
        final String NUMBER_REGEX = "[0-9]+";

        if(!number.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorCodeConstant.NUMBER_VALIDATION_ERROR);
        }
    }

    public static void isBlank(String characters){
        if(characters.isBlank()){
            throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
        }
    }

}
