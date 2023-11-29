package validator;

import static util.message.ExceptionMessage.*;

public class Validator {
    protected static void validateBlank(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

    protected static int validateType(final String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_MESSAGE.getValue());
        }
        return count;
    }

    protected static int validateRange(final int input, final int range) {
        if (input <= range) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), range));
        }
        return input;
    }
}
