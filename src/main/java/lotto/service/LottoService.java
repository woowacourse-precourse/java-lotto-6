package lotto.service;

import java.util.List;
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
        List<Result> results = purchasedLottos.getLottoDtos().stream()
                .map((lotto) -> Result.calculate(lotto, winningNumber, bonusNumber))
                .toList();
    }
}
