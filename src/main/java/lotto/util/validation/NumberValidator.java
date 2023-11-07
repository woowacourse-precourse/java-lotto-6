package lotto.util.validation;

import static lotto.exception.ExceptionMessage.MUST_BE_DIGIT;

import java.util.regex.Pattern;

public class NumberValidator extends AbstractValidator<String> {
    private static final String NUMBER_REGEX = "^\\d+$";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    @Override
    public void validate(final String target) {
        validateNotNull(target);
        validateDigit(target);
    }

    private void validateDigit(final String target) {
        final boolean isDigit = NUMBER_PATTERN.matcher(target).matches();
        if (!isDigit) {
            throwFail(MUST_BE_DIGIT.format());
        }
    }
}
