package lotto.validation;

import lotto.domain.WinningNumber;
import lotto.enums.Delimiter;
import lotto.enums.LottoValue;

public class BonusNumberValidator {
    private static final String ERROR_PREFIX = Delimiter.ERROR_PREFIX.getDelimiter();

    private BonusNumberValidator() {
    }

    public static void validateRange(int number) {
        int minNumberRange = LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue();
        if (number < minNumberRange || number > maxNumberRange) {
            throw new IllegalArgumentException(ERROR_PREFIX + "로또 번호는 6개의 번호로 이뤄져야 합니다.");
        }
    }

    public static void validateNotContainedInWinningNumber(int number, WinningNumber winningNumber) {
        if (winningNumber.isContains(number)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이미 당첨번호에 존재하는 번호 입니다.");
        }
    }
}
