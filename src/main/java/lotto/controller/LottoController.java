package lotto.controller;

import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.InputService;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.View;

public class LottoController {

    LottoService lottoService = new LottoService();
    public void run(){
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        int purchaseCount = calculatePurchaseCount(purchaseAmount);

        BuyLottoRepository buyLottos = lottoService.quickPick(purchaseCount);
        WinningLottoRepository winningLotto = lottoService.createWinningNumber();

        ResultService.perLottoTotalCount(buyLottos, winningLotto);
        ResultService.calculateRateOfReturn(purchaseCount);
    }

    private PurchaseAmount createPurchaseAmount() {
        View.requestPurchaseAmount();
        return PurchaseAmount.from(InputService.number());
    }

    private int calculatePurchaseCount(PurchaseAmount purchaseAmount) {
        int purchaseCount = purchaseAmount.calculateCount();
        View.purchaseCount(purchaseCount);
        return purchaseCount;
    }
}
