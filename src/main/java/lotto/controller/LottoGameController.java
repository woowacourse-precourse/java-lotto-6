package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;

public class LottoGameController {
    private final PurchasedLottoService purchasedLottoService;
    private final WinningLottoService winningLottoService;

    public LottoGameController(PurchasedLottoService purchasedLottoService, WinningLottoService winningLottoService) {
        this.purchasedLottoService = purchasedLottoService;
        this.winningLottoService = winningLottoService;
    }

    public void run() {
        PurchasedLotto purchasedLotto = purchasedLottoService.createPurchasedLotto();
        Lotto winningLotto = winningLottoService.craeteWinningLotto();

    }
}
