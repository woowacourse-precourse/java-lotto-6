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
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbers from(DrawnNumbersDto drawnNumbersDto) {
        return new DrawnNumbers(drawnNumbersDto.getWinningNumbers(), drawnNumbersDto.getBonusNumber());
    }

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

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateInvalidRange(winningNumbers);
        validateDuplication(winningNumbers);
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        if (isDuplicated(winningNumbers)) {
            throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    private boolean isDuplicated(List<Integer> winningNumbers) {
        int uniqueSize = getUniqueSize(winningNumbers);
        return uniqueSize != winningNumbers.size();
    }

    private int getUniqueSize(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .distinct()
                .count();
    }

    private void validateInvalidRange(List<Integer> winningNumbers) {
        if (isInvalidRange(winningNumbers)) {
            throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
        }
    }

    private boolean isInvalidRange(List<Integer> winningNumbers) {
        return !winningNumbers.stream()
                .allMatch(number ->
                        number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue()
                );
    }

    private void validateBonusNumber(Integer bonusNumber) {
        validateInvalidRange(bonusNumber);
        validateDuplication(bonusNumber);
    }

    private void validateInvalidRange(Integer bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
        }
    }

    private boolean isInvalidRange(Integer bonusNumber) {
        return bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue();
    }

    private void validateDuplication(Integer bonusNumber) {
        if (isDuplicatedWithWinningNumbers(bonusNumber)) {
            throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    private boolean isDuplicatedWithWinningNumbers(Integer bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }
}
