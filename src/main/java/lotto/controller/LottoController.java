package lotto.controller;

import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.InputService;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.View;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final ResultService resultService = new ResultService();
    public void run(){
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        int purchaseCount = calculatePurchaseCount(purchaseAmount);

        BuyLottoRepository buyLottos = lottoService.quickPick(purchaseCount);
        WinningLottoRepository winningLotto = lottoService.createWinningNumber();

        resultService.perLottoTotalCount(buyLottos, winningLotto);
        resultService.calculateRateOfReturn(purchaseCount);
    }

    private PurchaseAmount createPurchaseAmount() {
        return PurchaseAmount.from(InputService.number());
    }

    private int calculatePurchaseCount(PurchaseAmount purchaseAmount) {
        int purchaseCount = purchaseAmount.calculateCount();
        View.purchaseCount(purchaseCount);
        return purchaseCount;
    }
}
