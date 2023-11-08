package lotto.validator;

import lotto.constant.ErrorMessages;

public class BonusNumberValidator {
    public static void validate(String bonusNumberInput) {
        isNumeric(bonusNumberInput);
        isInRange(bonusNumberInput);
        isUnique(bonusNumberInput);

    }

    private static void isUnique(String bonusNumberInput) {

    }

    private static void isInRange(String bonusNumberInput) {
        if (Integer.parseInt(bonusNumberInput) < 1 || Integer.parseInt(bonusNumberInput) > 45) {
            System.out.println(ErrorMessages.NOT_IN_RANGE.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_IN_RANGE.getMessage());
        }
    }

    private static void isNumeric(String bonusNumberInput) {
        try {
            Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.NOT_LOTTO_NUMBER.getMessage());
            throw new NumberFormatException(ErrorMessages.NOT_NUMBER.getMessage());
        }
    }
}
