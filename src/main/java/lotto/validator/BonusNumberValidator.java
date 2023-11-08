package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessages;

public class BonusNumberValidator {
    public static void validate(String bonusNumberInput, List<Integer> winningLotto) {
        isNumeric(bonusNumberInput);
        isInRange(bonusNumberInput);
        isUnique(bonusNumberInput, winningLotto);

    }

    private static void isUnique(String bonusNumberInput, List<Integer> winningLotto) {
        if (winningLotto.contains(Integer.parseInt(bonusNumberInput))) {
            System.out.println(ErrorMessages.NOT_UNIQUE.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_UNIQUE.getMessage());
        }

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
