package validator;

import lotto.Lotto;

public class BonusNumberValidator {
    private BonusNumberValidator() {
    }

    public static void isNumeric(String bonusNumber) {
        try {
            int integerBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void inRange(String bonusNumber) {
        int integerBonusNumber = Integer.parseInt(bonusNumber);
        if (integerBonusNumber < 1 || integerBonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public static void duplicate(Lotto winningNumbers, String bonusNumber) {
        int integerBonusNumber = Integer.parseInt(bonusNumber);
        if (winningNumbers.getNumbers().contains(integerBonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
