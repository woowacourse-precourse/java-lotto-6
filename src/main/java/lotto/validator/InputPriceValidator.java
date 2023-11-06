package lotto.validator;

import lotto.exception.*;

public class InputPriceValidator {
    private static final Integer DIVIDE_BY = 1000;
    private static final Integer LOWEST_PRICE = 0;
    private static final Integer REST = 0;

    private static final String DELIMITER = ",";
    private InputPriceValidator() {
    }
    private static void validateEndsWithComma(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw new InvalidInputException();
        }
    }
    private static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new EmptyException();
        }
    }
    private static void validatePriceRange(final int price) {
        if (price < LOWEST_PRICE) {
            throw new InvalidPriceRangeException();
        }
    }
    private static void validatePriceFormat(final int number) {
        if(number % DIVIDE_BY != REST) {
            throw new InvalidInputPriceException();
        }
    }
    private static void validatePriceIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidPriceTypeException();
        }
    }
    public static void validatePrice(final String input) {
        validateEmpty(input);
        validateEndsWithComma(input);
        validatePriceIsNumeric(input);
        validatePriceFormat(Integer.parseInt(input));
        validatePriceRange(Integer.parseInt(input));
    }

}
