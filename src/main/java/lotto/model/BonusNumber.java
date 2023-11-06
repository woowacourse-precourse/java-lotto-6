package lotto.model;

import java.util.List;
import lotto.utils.enums.Code;
import lotto.utils.InputValidator;
import lotto.utils.enums.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(List<Integer> numbers, int bonusNumber) {
        validateDuplicatedWinningAndBonus(numbers, bonusNumber);
        InputValidator.validateNumberInRange(bonusNumber, Code.BONUS.getCode());
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedWinningAndBonus(
            List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATED.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
