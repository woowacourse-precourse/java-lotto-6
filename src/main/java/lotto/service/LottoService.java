package lotto.service;

import lotto.dto.LottosDto;
import lotto.model.BonusNumber;
import lotto.model.Result;
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

    public void calculateWinningStatistics(LottosDto purchasedLottos) {
        Result lottoResult = Result.calculate(purchasedLottos.getLottoDtos(), winningNumber, bonusNumber);
    }
}
