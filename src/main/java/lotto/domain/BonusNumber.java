package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessage;

public class BonusNumber {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = stringToIntConverter(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber, Lotto winningNumbers) {
        if (!isDigit(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_DIGIT.getMessage());
        }
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
        }
        if (!isUnique(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_UNIQUE.getMessage());
        }
    }

    private boolean isUnique(String inputBonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        int bonusNumber = stringToIntConverter(inputBonusNumber);
        for (Integer number : numbers) {
            if (number == bonusNumber) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(String bonusNumber) {
        try {
            stringToIntConverter(bonusNumber.trim());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isInRange(String inputBonusNumber) {
        int bonusNumber = stringToIntConverter(inputBonusNumber);
        return bonusNumber >= LOTTO_NUMBER_RANGE_MIN && bonusNumber <= LOTTO_NUMBER_RANGE_MAX;
    }

    private int stringToIntConverter(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
