package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;

public class LottoService {

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public void validateWinningNumber(String candidateWinningNumber) {
        winningNumber = WinningNumber.create(candidateWinningNumber);
    }

    public void validateBonusNumber(String candidateBonusNumber) {
        bonusNumber = BonusNumber.create(candidateBonusNumber, winningNumber);
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
