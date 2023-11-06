package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;

public class LottoGameController {
    private final PurchasedLottoService purchasedLottoService;
    private final WinningLottoService winningLottoService;
    private final BonusNumberService bonusNumberService;

    public LottoGameController(PurchasedLottoService purchasedLottoService, WinningLottoService winningLottoService, BonusNumberService bonusNumberService) {
        this.purchasedLottoService = purchasedLottoService;
        this.winningLottoService = winningLottoService;
        this.bonusNumberService = bonusNumberService;
    }

    public void run() {
        PurchasedLotto purchasedLotto = purchasedLottoService.createPurchasedLotto();
        Lotto winningLotto = winningLottoService.craeteWinningLotto();
        BonusNumber bonusNumber = bonusNumberService.craeteBonusNumber(winningLotto);
    }
}
