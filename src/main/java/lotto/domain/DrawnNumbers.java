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
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (isInvalidRange(winningNumbers)) {
            throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
        }
    }

    private boolean isInvalidRange(List<Integer> winningNumbers) {
        return winningNumbers
                .stream()
                .allMatch(number ->
                        number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue()
                );
    }

    public static DrawnNumbers from(DrawnNumbersDto drawnNumbersDto) {
        return new DrawnNumbers(drawnNumbersDto.getWinningNumbers(), drawnNumbersDto.getBonusNumber());
    }
}
