package lotto.util.validator;


import lotto.constant.ErrorMessage;
import lotto.vo.WinningNumbers;

public class BonusNumberValidator extends AbstractNumberValidator<Integer> {
    private final WinningNumbers winningNumbers;

    public BonusNumberValidator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate(Integer input) {
        validateNumberInRange(input);
        validateDuplicatedWithNumbers(input);
    }

    private void validateDuplicatedWithNumbers(Integer bonusNumber) {
        if (winningNumbers.isContained(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_IS_DUPLICATED);
        }
    }
}
