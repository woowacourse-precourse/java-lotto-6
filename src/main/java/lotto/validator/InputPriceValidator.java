package lotto.validator;

import lotto.exception.*;

public class InputPriceValidator {

    private static final Integer DIVIDE_BY = 1000;
    private static final Integer LOWEST_PRICE = 0;
    private static final Integer REST = 0;
    private static final String DELIMITER = ",";
    private InputPriceValidator() {
    }

    private static void validateEndsWithComma(final String price) {
        if (price.endsWith(DELIMITER)) {
            throw new InvalidInputException();
        }
    }

    private static void validateEmpty(final String price) {
        if (price.isEmpty()) {
            throw new EmptyException();
        }
    }

    private static void validatePriceRange(final int price) {
        if (price < LOWEST_PRICE) {
            throw new InvalidPriceRangeException();
        }
    }

    private static void validatePriceFormat(final int price) {
        if(price % DIVIDE_BY != REST) {
            throw new InvalidInputPriceException();
        }
    }

    private static void validatePriceIsNumeric(final String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new InvalidPriceTypeException();
        }
    }

    public static void validatePrice(final String price) {
        validateEmpty(price);
        validateEndsWithComma(price);
        validatePriceIsNumeric(price);
        validatePriceFormat(Integer.parseInt(price));
        validatePriceRange(Integer.parseInt(price));
    }

}
