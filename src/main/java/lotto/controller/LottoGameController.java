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
        PurchasedLotto purchasedLotto = initPurchasedLotto();
        Lotto winningLotto = initWinningLotto();

    }

    private PurchasedLotto initPurchasedLotto() {
        PurchasedLotto purchasedLotto = purchasedLottoService.createPurchasedLotto();
        purchasedLottoService.printPurchasedLotto(purchasedLotto);
        return purchasedLotto;
    }

    private Lotto initWinningLotto() {
        return winningLottoService.craeteWinningLotto();
    }





}
