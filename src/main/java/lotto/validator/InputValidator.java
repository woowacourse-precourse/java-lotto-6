package lotto.validator;

import lotto.constant.LottoConstants;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validateInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputData(int amount) {
        try {
            InputValidator.validateAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }


    private static void validateAmount(int amount) {
        if (amount % LottoConstants.UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

}
