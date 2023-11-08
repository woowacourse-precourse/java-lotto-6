package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotties;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.service.LottoGameService;

public class LottoGameController {
    private LottoGameService service;

    public LottoGameController(LottoGameService service) {
        this.service = service;
    }

    public void run(PurchaseAmount amount, WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotties lotties) {
        WinningResult winningResult = service.calculateWinningResult(lotties.getLotties(),
                winningNumbers.getWinningNumbers(), bonusNumber);
        int sum = service.sumWinningAmount(winningResult);
        String rateOfReturn = service.calculateRateOfReturn(amount.getAmount(), sum);
    }

    private void playGame() {
    }
}
