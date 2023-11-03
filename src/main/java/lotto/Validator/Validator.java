package lotto.Validator;

import lotto.Validator.ValidatorConstant;

public class Validator {
    private static final int LOTTO_PRICE = 1000;

    public static int validateParseInt(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorConstant.PARSE_INT_ERROR.getMessage());
        }
    }

    public static void validateDivisibleBy1000(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ValidatorConstant.Not_DIVISION_BY_1000_ERROR.getMessage());
        }
    }
}
