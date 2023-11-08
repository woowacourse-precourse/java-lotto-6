package lotto.domain;

import java.util.List;
import lotto.dto.LottoResultDto;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

/**
 * 당첨 번호와 보너스 번호를 저장하는 클래스
 */
public class DrawnNumbers {
    private final WinningNumbers winningNumbers;
    private final Number bonusNumber;

    private DrawnNumbers(final WinningNumbers winningNumbers, final Number bonusNumber) {
        Validator.validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbers from(final WinningNumbers winningNumbers, final Number bonusNumber) {
        return new DrawnNumbers(winningNumbers, bonusNumber);
    }

    /**
     * 로또 번호와 당첨 번호, 보너스 번호를 비교해서 당첨 결과를 생성
     *
     * @param lotto 발행한 6개의 로또 번호
     * @return 매칭되는 당첨 번호 개수와 보너스 번호의 포함 여부
     */
    public LottoResultDto compare(final Lotto lotto) {
        List<Number> numbers = lotto.getNumbers();

        int winningCount = winningNumbers.countMatchedNumbers(numbers);
        boolean hasBonusNumber = numbers.contains(bonusNumber);

        return LottoResultDto.of(winningCount, hasBonusNumber);
    }

    private static class Validator {
        /**
         * 보너스 번호의 유효성을 검증하는 메서드
         *
         * @param bonusNumber 보너스 번호
         */
        private static void validateBonusNumber(final WinningNumbers winningNumbers,
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
