package lotto.domain;

import static lotto.util.InputValidator.validateNumberInRange;

import lotto.enums.ErrorMessages;

public class Answer {
    private final Lotto hitNumbers;
    private final int bonusNumber;

    public Answer(Lotto hitNumbers, int bonusNumber) {
        this.hitNumbers = hitNumbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateNumberInRange(bonusNumber);
        validateBonusNumberConflictWithAnswer(bonusNumber);
    }

    private void validateBonusNumberConflictWithAnswer(int bonusNumber) {
        boolean duplicatedFlag = hitNumbers.findNumber(bonusNumber);
        if (duplicatedFlag) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMER_CONFLICT_EXCEPTION_MSG.getMsg());
        }
    }

    public boolean isHitNumbersHaveThisNumber(int number) {
        return hitNumbers.findNumber(number);
    }

    public boolean isBonusNumberTheSameAsThis(int number) {
        return number == bonusNumber;
    }
}
