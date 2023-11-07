package lotto.domain;

import lotto.constants.BonusNumberErrorMessage;

import java.util.List;

public class BonusNumber {
    private static final int START_RANGE_VALUE = 1;
    private static final int END_RANGE_VALUE = 45;

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(String bonusNumber, List<Integer> winningBundle) {
        validateNumeric(bonusNumber);
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        validateRange(convertedBonusNumber);
        validateDuplication(convertedBonusNumber, winningBundle);
        return new BonusNumber(convertedBonusNumber);
    }

    private static void validateNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.NUMERIC_INVALID.entireMessage());
        }
    }

    public static void validateRange(int bonusNumber) {
        if (isOverRange(bonusNumber)) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.RANGE_INVALID.entireMessage());
        }
    }

    private static boolean isOverRange(int number) {
        return number < START_RANGE_VALUE || number > END_RANGE_VALUE;
    }

    private static void validateDuplication(int bonusNumber, List<Integer> winningBundle) {
        if(winningBundle.contains(bonusNumber)) {
            throw new IllegalStateException(BonusNumberErrorMessage.DUPLICATE_WINNING_BUNDLE_INVALID.entireMessage());
        };
    }

    public int toInt() {
        return bonusNumber;
    }
}
