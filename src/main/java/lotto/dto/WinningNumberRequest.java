package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.exception.InvalidWinningNumberException;

public record WinningNumberRequest(List<Integer> winningNumber) {

    public WinningNumberRequest {
        if (isInValidWinningNumberSize(winningNumber.size())) {
            throw new InvalidWinningNumberException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT);
        }

        if (isWinningNumberContainsDuplicatedNumber(winningNumber)) {
            throw new InvalidWinningNumberException(
                ErrorMessage.WINNING_NUMBER_CONTAINS_DUPLICATED_NUMBER);
        }

        if (isWinningNumberOutOfRange(winningNumber)) {
            throw new InvalidWinningNumberException(ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    private Boolean isInValidWinningNumberSize(Integer winningNumberSize) {
        return winningNumberSize != LottoConstant.LOTTO_NUMBER_COUNT.getValue();
    }

    private Boolean isWinningNumberContainsDuplicatedNumber(List<Integer> winningNumber) {
        Set<Integer> numberSet = new HashSet<>(winningNumber);
        return numberSet.size() != winningNumber.size();
    }

    private Boolean isWinningNumberOutOfRange(List<Integer> winningNumber) {
        return winningNumber.stream().anyMatch(this::isNumberOutOfRange);
    }

    private Boolean isNumberOutOfRange(Integer number) {
        return number < LottoConstant.LOTTO_NUMBER_MIN.getValue()
            || number > LottoConstant.LOTTO_NUMBER_MAX.getValue();
    }
}
