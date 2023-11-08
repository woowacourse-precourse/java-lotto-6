package util;

import java.util.List;
import lotto.LottoPrinciples;

public class ValidationBonusNumber {

    private ValidationBonusNumber() {

    }

    public static void validateBonusNumber(String bonusNumberString) {
        validateNumber(bonusNumberString);
        validateNumberRange(bonusNumberString);
    }

    public static void validateDuplicateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ValidationBonusNumberMessages.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateNumber(String bonusNumberString) {
        try {
            Integer price = Integer.parseInt(bonusNumberString);
        } catch (NumberFormatException notANumberException) {
            throw new IllegalArgumentException(ValidationBonusNumberMessages.NOT_A_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(String bonusNumberString) {
        Integer bonusNumber = Integer.parseInt(bonusNumberString);

        if (LottoPrinciples.MIN_NUMBER.getNumber() > bonusNumber
                || LottoPrinciples.MAX_NUMBER.getNumber() < bonusNumber) {
            throw new IllegalArgumentException(ValidationBonusNumberMessages.INVALID_NUMBER.getMessage());
        }
    }
}
