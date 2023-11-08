package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWallet;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView consoleLottoView;
    private final LottoService lottoService;

    public LottoController(LottoView consoleLottoView, LottoService lottoService) {
        this.consoleLottoView = consoleLottoView;
        this.lottoService = lottoService;
    }

    public void startGame() {
        LottoWallet lottoWallet = purchaseLotto();
        System.out.println(lottoWallet);
    }

    private LottoWallet purchaseLotto() {
        try {
            int purchaseAmount = consoleLottoView.getPurchaseAmount();
            return lottoService.purchase(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }


}
