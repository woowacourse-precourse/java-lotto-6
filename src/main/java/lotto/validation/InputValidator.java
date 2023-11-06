package lotto.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.util.ExceptionHandler;

public class InputValidator {
    public static void validateForNonNumericCharacters(String input) {
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            ExceptionHandler.throwNonNumericInputException();
        }
    }
}
