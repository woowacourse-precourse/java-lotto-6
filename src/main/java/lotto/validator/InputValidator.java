package lotto.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.WrongLottoInputFormatException;

public class InputValidator {

    public static void validate(String input, String regex, IllegalArgumentException exception) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {

            throw exception;

        }
    }
}
