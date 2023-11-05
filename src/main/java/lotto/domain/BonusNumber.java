package lotto.domain;

import java.util.List;
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
        List<Integer> winnings = WinningNumberRepository.findWinningNumbers();
        for (Integer winning : winnings) {
            if (isEqual(number, winning)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
            }
        }
    }

    private boolean isEqual(int bonus, int winning) {
        return bonus == winning;
    }

    public int getNumber() {
        return number;
    }
}
