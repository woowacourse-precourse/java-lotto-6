package lotto.util.validator;

import java.util.List;
import lotto.domain.LottoNumberRange;
import lotto.domain.repository.WinningNumberRepository;
import lotto.util.ExceptionMessage;
import lotto.util.Util;

public class BonusNumberValidator implements Validatable {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        int number = Util.convertStringToInt(input);
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
}
