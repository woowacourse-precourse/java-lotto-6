package lotto.domain;

import static lotto.util.InputValidator.validateNumberInRange;

import java.util.List;
import lotto.enums.ErrorMessages;

public class Answer {
    private final Lotto hitNumbers;
    private final int bonusNumber;

    public Answer(Lotto hitNumbers, int bonusNumber) {
        validate(hitNumbers, bonusNumber);
        this.hitNumbers = hitNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto hitNumbers, int bonusNumber) {
        validateNumberInRange(bonusNumber);
        validateBonusNumberConflictWithAnswer(hitNumbers, bonusNumber);
    }

    private void validateBonusNumberConflictWithAnswer(Lotto hitNumbers, int bonusNumber) {
        List<Integer> numbers = hitNumbers.getNumbers();
        boolean duplicatedFlag = numbers.contains(bonusNumber);
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
