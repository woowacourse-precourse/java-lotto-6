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
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private DrawnNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
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
        List<Integer> numbers = lotto.getNumbers();
        int winningCount = countWinningNumbers(numbers);
        boolean hasBonusNumber = numbers.contains(bonusNumber);
        return LottoResultDto.of(winningCount, hasBonusNumber);
    }

    private int countWinningNumbers(List<Integer> numbers) {
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
        private static void validateWinningNumbers(List<Integer> winningNumbers) {
            validateInvalidRange(winningNumbers);
            validateDuplication(winningNumbers);
        }

        private static void validateInvalidRange(List<Integer> winningNumbers) {
            if (isInvalidRange(winningNumbers)) {
                throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
            }
        }

        private static boolean isInvalidRange(List<Integer> winningNumbers) {
            return !winningNumbers.stream()
                    .allMatch(number ->
                            number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue()
                    );
        }

        private static void validateDuplication(List<Integer> winningNumbers) {
            if (isDuplicated(winningNumbers)) {
                throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static boolean isDuplicated(List<Integer> winningNumbers) {
            int uniqueSize = getUniqueSize(winningNumbers);
            return uniqueSize != winningNumbers.size();
        }

        private static int getUniqueSize(List<Integer> winningNumbers) {
            return (int) winningNumbers.stream()
                    .distinct()
                    .count();
        }

        /**
         * 보너스 번호의 유효성을 검증하는 메서드
         *
         * @param bonusNumber 보너스 번호
         */
        private static void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
            validateInvalidRange(bonusNumber);
            validateDuplication(winningNumbers, bonusNumber);
        }

        private static void validateInvalidRange(Integer bonusNumber) {
            if (isInvalidRange(bonusNumber)) {
                throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
            }
        }

        private static boolean isInvalidRange(Integer bonusNumber) {
            return bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue();
        }

        private static void validateDuplication(List<Integer> winningNumbers, Integer bonusNumber) {
            if (isDuplicatedWithWinningNumbers(winningNumbers, bonusNumber)) {
                throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static boolean isDuplicatedWithWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
            return winningNumbers.contains(bonusNumber);
        }
    }
}
