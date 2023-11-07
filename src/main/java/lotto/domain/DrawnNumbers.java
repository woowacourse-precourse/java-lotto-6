package lotto.domain;

import static lotto.global.constants.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constants.NumberType.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.dto.DrawnNumbersDto;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class DrawnNumbers {
    private final List<Integer> winningNumbers;

    private final Integer bonusNumber;

    private DrawnNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        Validator.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbers from(DrawnNumbersDto drawnNumbersDto) {
        return new DrawnNumbers(drawnNumbersDto.getWinningNumbers(), drawnNumbersDto.getBonusNumber());
    }

    private static class Validator {
        private static void validateWinningNumbers(List<Integer> winningNumbers) {
            validateInvalidRange(winningNumbers);
            validateDuplication(winningNumbers);
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

        private static void validateInvalidRange(List<Integer> winningNumbers) {
            if (isInvalidRange(winningNumbers)) {
                throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
            }
        }

        private static boolean isInvalidRange(List<Integer> winningNumbers) {
            return winningNumbers.stream()
                    .allMatch(number ->
                            number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue()
                    );
        }
    }
}
