package lotto.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.NonPureNumberException;

public class PureNumber {

    private static final Pattern PURE_NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private final Integer number;

    public static PureNumber wrap(String rawInput) throws NonPureNumberException {
        return new PureNumber(rawInput.trim());
    }

    public Integer getNumber() {
        return number;
    }

    private PureNumber(String rawInput) throws NonPureNumberException {
        validatePureNumber(rawInput);
        number = Integer.parseInt(rawInput);
    }

    private void validatePureNumber(String rawInput) throws NonPureNumberException {
        Matcher matcher = PURE_NUMBER_PATTERN.matcher(rawInput);
        if (!matcher.matches()) {
            throw new NonPureNumberException();
        }
    }
}
