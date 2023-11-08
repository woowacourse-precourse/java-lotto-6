package lotto.domain;

import static lotto.global.constants.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constants.NumberType.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.dto.DrawnNumbersDto;
import lotto.dto.LottoResultDto;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

/**
 * 당첨 번호와 보너스 번호를 저장하는 클래스
 */
public class DrawnNumbers {
    private final List<Number> winningNumbers;
    private final Number bonusNumber;

    private DrawnNumbers(List<Number> winningNumbers, Number bonusNumber) {
        Validators.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;

        Validators.validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbers from(DrawnNumbersDto drawnNumbersDto) {
        return new DrawnNumbers(drawnNumbersDto.getWinningNumbers(), drawnNumbersDto.getBonusNumber());
    }

    /**
     * 로또 번호와 당첨 번호, 보너스 번호를 비교해서 당첨 결과를 생성
     *
     * @param lotto 발행한 6개의 로또 번호
     * @return 매칭되는 당첨 번호 개수와 보너스 번호의 포함 여부
     */
    public LottoResultDto compare(Lotto lotto) {
        List<Number> numbers = lotto.getNumbers();
        int winningCount = countWinningNumbers(numbers);
        boolean hasBonusNumber = numbers.contains(bonusNumber);
        return LottoResultDto.of(winningCount, hasBonusNumber);
    }

    private int countWinningNumbers(List<Number> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static class Validators {
        /**
         * 당첨 번호의 유효성을 검증하는 메서드
         *
         * @param winningNumbers 당첨 번호
         */
        private static void validateWinningNumbers(List<Number> winningNumbers) {
            validateDuplication(winningNumbers);
        }

        private static void validateDuplication(List<Number> winningNumbers) {
            if (isDuplicated(winningNumbers)) {
                throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static boolean isDuplicated(List<Number> winningNumbers) {
            int uniqueSize = getUniqueSize(winningNumbers);
            return uniqueSize != winningNumbers.size();
        }

        private static int getUniqueSize(List<Number> winningNumbers) {
            return (int) winningNumbers.stream()
                    .distinct()
                    .count();
        }

        /**
         * 보너스 번호의 유효성을 검증하는 메서드
         *
         * @param bonusNumber 보너스 번호
         */
        private static void validateBonusNumber(List<Number> winningNumbers, Number bonusNumber) {
            validateDuplication(winningNumbers, bonusNumber);
        }

        private static void validateDuplication(List<Number> winningNumbers, Number bonusNumber) {
            if (isDuplicatedWithWinningNumbers(winningNumbers, bonusNumber)) {
                throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static boolean isDuplicatedWithWinningNumbers(List<Number> winningNumbers, Number bonusNumber) {
            return winningNumbers.contains(bonusNumber);
        }
    }
}
