package lotto.global;

import java.util.regex.Pattern;

public class ValidationUtils {
    public static final Pattern NUMBER_CHECK_PATTERN = Pattern.compile("^[0-9]+$");

    public static void checkNumber(String input){
        if(!NUMBER_CHECK_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_INPUT_NUMBER.getMessage());
        }
    }
}
