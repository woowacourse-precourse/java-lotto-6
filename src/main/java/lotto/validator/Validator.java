package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ExceptionMessages.NUMBER_TYPE_ERROR_MESSAGE;

public class Validator {

    public static final String REGEXP_NUMBER = "^[0-9]*$";

    public static void checkNumberType(String input){
        if (Pattern.matches(REGEXP_NUMBER, input)) {
            return;
        }
        throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE.getMessage());
    }

    public static void checkAllNumberType(String[] inputs) {
        Arrays.stream(inputs).forEach(Validator::checkNumberType);
    }

}
