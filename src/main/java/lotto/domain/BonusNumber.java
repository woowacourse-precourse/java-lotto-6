package lotto.domain;

import java.util.List;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class BonusNumber {
    private Number bonusNumber;

    private BonusNumber(WinningNumbers winningNumbers, Number bonusNumber) {
        Validator.validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(WinningNumbers winningNumbers, Number bonusNumber) {
        return new BonusNumber(winningNumbers, bonusNumber);
    }

    public boolean contains(List<Number> numbers) {
        return numbers.contains(bonusNumber);
    }

    private static class Validator {
        /**
         * 보너스 번호의 유효성을 검증하는 메서드
         *
         * @param bonusNumber 보너스 번호
         */
        private static void validate(final WinningNumbers winningNumbers,
                                     final Number bonusNumber) {
            validateDuplication(winningNumbers, bonusNumber);
        }

        private static void validateDuplication(final WinningNumbers winningNumbers,
                                                final Number bonusNumber) {
            if (isDuplicatedWithWinningNumbers(winningNumbers, bonusNumber)) {
                throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static boolean isDuplicatedWithWinningNumbers(final WinningNumbers winningNumbers,
                                                              final Number bonusNumber) {
            return winningNumbers.contains(bonusNumber);
        }
    }
}
