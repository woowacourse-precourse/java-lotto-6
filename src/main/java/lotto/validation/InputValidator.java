package lotto.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.domain.ConstantValue;
import lotto.util.ExceptionHandler;

public class InputValidator {

    public static void validateUserInput(String input) {
        validateForNonNumericCharacters(input);
        validateNumberLessThan1000(input);
        validateChangeAvailableFor1000(input);
    }

    public static void validateForNonNumericCharacters(String input) {
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            ExceptionHandler.throwNonNumericInputException();
        }
    }

    public static void validateNumberLessThan1000(String input) {
        int number = Integer.parseInt(input);

        if (number < ConstantValue.THOUSAND) {
            ExceptionHandler.throwNumberBelow1000Exception();
        }
    }

    public static void validateChangeAvailableFor1000(String input) {
        int number = Integer.parseInt(input);

        int remainder = number % ConstantValue.THOUSAND;
        if (remainder > 0) {
            ExceptionHandler.throwChangeAvailableException();
        }
    }
}
