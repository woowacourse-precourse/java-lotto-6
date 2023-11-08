package lotto.validator;

import static lotto.config.BonusNumberErrorMessage.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.config.InputPattern.BONUS_NUMBER_REGEX;

import java.util.regex.Pattern;

public class BonusNumberValidator implements Validator<String> {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(BONUS_NUMBER_REGEX.getRegex());

    @Override
    public String validate(String input) {
        numeric(input);
        return input;
    }

    private void numeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }
}
