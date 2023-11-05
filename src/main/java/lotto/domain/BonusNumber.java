package lotto.domain;

import lotto.domain.repository.WinningNumberRepository;
import lotto.util.ExceptionMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateNumberRange(number);
        validateDuplicateWithWinningNumber(number);
    }

    private void validateNumberRange(int number) {
        if (number < LottoNumberRange.MIN_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_MIN_RANGE.getMessage());
        }
        if (number > LottoNumberRange.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_MAX_RANGE.getMessage());
        }
    }

    private void validateDuplicateWithWinningNumber(int number) {
        WinningNumber winningNumber = WinningNumberRepository.findByIndex(0);
        for (int i = 0; i < winningNumber.getNumbers().size(); i++) {
            if (isEqual(number, winningNumber.findNumberByIndex(i))) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_WINNING_NUMBER.getMessage());
            }
        }
    }

    private boolean isEqual(int bonus, int winning) {
        return bonus == winning;
    }
}
