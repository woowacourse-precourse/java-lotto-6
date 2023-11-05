package lotto.controller;

import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.InputService;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {

    LottoService lottoService = new LottoService();
    public void run(){
        View.requestPurchaseAmount();
        PurchaseAmount purchaseAmount = PurchaseAmount.from(InputService.number());

        int purchaseCount = purchaseAmount.calculateCount();
        View.purchaseCount(purchaseCount);
        BuyLottoRepository buyLottoRepo = lottoService.quickPick(purchaseCount);
        WinningLottoRepository winningLottoRepo = lottoService.createWinningNumber();
    }
}
