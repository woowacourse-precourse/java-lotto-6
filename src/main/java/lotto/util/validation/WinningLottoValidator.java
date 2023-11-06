package lotto.util.validation;

import static lotto.exception.ExceptionMessage.DUPLICATE_BONUS_NUMBER;

import java.util.List;

public class WinningLottoValidator extends AbstractValidator<List<Integer>> {
    private final int bonusNumber;

    public WinningLottoValidator(final int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate(final List<Integer> winningNumbers) {
        validateNotNull(winningNumbers);
        validateDuplicateLottoNumber(winningNumbers);
    }

    private void validateDuplicateLottoNumber(final List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }
}
