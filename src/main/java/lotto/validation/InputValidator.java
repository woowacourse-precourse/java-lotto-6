package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String SEPARATOR = ",";

    Pattern pattern = Pattern.compile("^[0-9]+$");
    Matcher matcher;

    public void isNumber(String input) {
        matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public void isNumbers(String input) {
        for (String split : input.split(SEPARATOR)) {
            isNumber(split);
        }
    }
}
