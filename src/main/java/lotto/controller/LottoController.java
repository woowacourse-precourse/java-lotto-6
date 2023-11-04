package lotto.controller;

import lotto.service.InputService;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {

    public void run(){
        View.requestPurchaseAmount();
        PurchaseAmount purchaseAmount = PurchaseAmount.from(InputService.number());

        int purchaseCount = purchaseAmount.calculateCount();
        View.purchaseCount(purchaseCount);
        LottoService.createRandomNumber(purchaseCount);

        LottoService.createWinningNumber();
    }
}
