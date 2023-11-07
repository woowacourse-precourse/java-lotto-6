package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.exception.ErrorMessage;

public class BonusNumberValidator {
    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_VALUE_MESSAGE.getMessage());
        }

        if (!InputValidator.isMatchedNumberRegex(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_CHARACTER_MESSAGE.getMessage());
        }
    }

    public static void validateBonusNumber(final int number, final WinningLotto winningLotto) {
        validateNumbersInLottoRange(number);
        validateBonusNumberDuplicate(winningLotto, number);
    }

    private static void validateNumbersInLottoRange(final int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_WINNING_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public static void validateBonusNumberDuplicate(final WinningLotto winningLotto,
                                                    final int number) {
        boolean isDuplicate = winningLotto.getNumbers().contains(number);

        if (isDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }
}
