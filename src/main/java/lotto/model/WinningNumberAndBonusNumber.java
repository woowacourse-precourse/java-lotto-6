package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.dto.BonusNumberRequest;
import lotto.dto.WinningNumberRequest;
import lotto.exception.InvalidLottoNumberException;

public final class WinningNumberAndBonusNumber {

    private final List<Integer> winningNumber;
    private final Integer bonusNumber;

    public WinningNumberAndBonusNumber(WinningNumberRequest winningNumberRequest,
        BonusNumberRequest bonusNumberRequest) {
        final List<Integer> winningNumber = winningNumberRequest.winningNumber();
        final Integer bonusNumber = bonusNumberRequest.bonusNumber();
        if (winningNumber.contains(bonusNumber)) {
            throw new InvalidLottoNumberException(
                ErrorMessage.BONUS_NUMBER_CONTAINED_WINNING_NUMBER);
        }
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
