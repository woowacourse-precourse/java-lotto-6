package lotto.model;

import java.util.List;
import lotto.dto.BonusNumberRequest;
import lotto.dto.WinningNumberRequest;

public final class WinningNumberAndBonusNumber {

    private final List<Integer> winningNumber;
    private final Integer bonusNumber;

    public WinningNumberAndBonusNumber(WinningNumberRequest winningNumberRequest,
        BonusNumberRequest bonusNumberRequest) {
        this.winningNumber = winningNumberRequest.winningNumber();
        this.bonusNumber = bonusNumberRequest.bonusNumber();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
