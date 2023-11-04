package lotto.util.parser;

public class NumberParserImpl implements NumberParser {
    private static final int MINIMUM_LENGTH = 1;
    private static final String REGEX = "^[0-9]+$";

    @Override
    public int parse(String input) {
        if (!hasLengthAtLeast(input) || !isNumeric(input)) {
            return -1;
        }
        return Integer.parseInt(input);
    }

    private boolean hasLengthAtLeast(String input) {
        return input.length() >= MINIMUM_LENGTH;
    }

    private boolean isNumeric(String input) {
        return input.matches(REGEX);
    }
}
