package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.exception.InvalidWinningNumberException;
import lotto.validator.LottoValidator;

public record WinningNumberRequest(List<Integer> winningNumber) {

    public WinningNumberRequest {
        if (isInValidWinningNumberSize(winningNumber.size())) {
            throw new InvalidWinningNumberException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT);
        }

        if (isWinningNumberContainsDuplicatedNumber(winningNumber)) {
            throw new InvalidWinningNumberException(
                ErrorMessage.WINNING_NUMBER_CONTAINS_DUPLICATED_NUMBER);
        }

        for (Integer number : winningNumber) {
            LottoValidator.validateLottoNumberInRange(number);
        }
    }

    private Boolean isInValidWinningNumberSize(Integer winningNumberSize) {
        return winningNumberSize != LottoConstant.LOTTO_NUMBER_COUNT.getValue();
    }

    private Boolean isWinningNumberContainsDuplicatedNumber(List<Integer> winningNumber) {
        Set<Integer> numberSet = new HashSet<>(winningNumber);
        return numberSet.size() != winningNumber.size();
    }
}
