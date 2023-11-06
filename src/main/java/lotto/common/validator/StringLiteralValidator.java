package lotto.common.validator;

import lotto.common.constant.ErrorConstant;

public class StringLiteralValidator {

    public static void validatePositiveInteger(String literal) {
        validateInteger(literal);

        if (!isPositive(Integer.parseInt(literal))) {
            throw new IllegalArgumentException("%s is not positive integer.".formatted(literal));
        }
    }

    public static void validateInteger(String literal) {
        if (!isInteger(literal)) {
            throw new IllegalArgumentException("%s String literal %s is not numeric.".formatted(
                    ErrorConstant.ERROR_PREFIX, literal)
            );
        }
    }

    private static boolean isInteger(String literal) {
        try {
            Integer.parseInt(literal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositive(int target) {
        return target > 0;
    }

}
