package lotto.validator;

import static lotto.constant.Constants.MAX_LOTTO_NUMBER;
import static lotto.constant.Constants.MIN_LOTTO_NUMBER;

import lotto.constant.ErrorMessages;
import lotto.model.Lotto;

public class BonusNumberValidator {
    public static void validate(String bonusNumberInput, Lotto winningLotto) {
        isNumeric(bonusNumberInput);
        isInRange(bonusNumberInput);
        isUnique(bonusNumberInput, winningLotto);

    }

    private static void isUnique(String bonusNumberInput, Lotto winningLotto) {
        if (winningLotto.contains(Integer.parseInt(bonusNumberInput))) {
            System.out.println(ErrorMessages.NOT_UNIQUE.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_UNIQUE.getMessage());
        }

    }

    private static void isInRange(String bonusNumberInput) {
        if (Integer.parseInt(bonusNumberInput) < MIN_LOTTO_NUMBER
                || Integer.parseInt(bonusNumberInput) > MAX_LOTTO_NUMBER) {
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
