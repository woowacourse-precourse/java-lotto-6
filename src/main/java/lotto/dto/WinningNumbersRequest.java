package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.exception.InvalidWinningNumberException;

public record WinningNumbersRequest(List<Integer> winningNumbers) {

    public WinningNumbersRequest {
        if (isInValidWinningNumbersSize(winningNumbers.size())) {
            throw new InvalidWinningNumberException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT);
        }

        if (isWinningNumbersContainsDuplicatedNumber(winningNumbers)) {
            throw new InvalidWinningNumberException(
                ErrorMessage.WINNING_NUMBER_CONTAINS_DUPLICATED_NUMBER);
        }

        if (isWinningNumbersOutOfRange(winningNumbers)) {
            throw new InvalidWinningNumberException(ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    private Boolean isInValidWinningNumbersSize(Integer winningNumbersSize) {
        return winningNumbersSize != LottoConstant.LOTTO_NUMBER_COUNT.getValue();
    }

    private Boolean isWinningNumbersContainsDuplicatedNumber(List<Integer> winningNumbers) {
        Set<Integer> numbersSet = new HashSet<>(winningNumbers);
        return numbersSet.size() != winningNumbers.size();
    }

    private Boolean isWinningNumbersOutOfRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().anyMatch(this::isWinningNumberOutOfRange);
    }

    private Boolean isWinningNumberOutOfRange(Integer winningNumber) {
        return winningNumber < LottoConstant.LOTTO_NUMBER_MIN.getValue()
            || winningNumber > LottoConstant.LOTTO_NUMBER_MAX.getValue();
    }
}
