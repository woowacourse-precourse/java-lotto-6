package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotties;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGameService;

public class LottoGameController {
    private LottoGameService service;

    public LottoGameController(LottoGameService service) {
        this.service = service;
    }

    public void run(PurchaseAmount amount, WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotties lotties) {
        playGame();
    }

    private void playGame() {
    }
}
