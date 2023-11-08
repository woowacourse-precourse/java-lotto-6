package lotto.validator;

import lotto.constant.ErrorMessages;

public class BonusNumberValidator {
    public static void validate(String bonusNumberInput) {
        isNumeric(bonusNumberInput);
        isInRange(bonusNumberInput);
        isUnique(bonusNumberInput);

    }

    private static void isNumeric(String bonusNumberInput) {
        try {
            Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.NOT_LOTTO_NUMBER.getMessage());
            throw new NumberFormatException(ErrorMessages.NOT_BONUS.getMessage());
        }
    }
}
