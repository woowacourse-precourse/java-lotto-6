package lotto.controller;

import lotto.service.InputService;
import lotto.domain.PurchaseAmount;
import lotto.view.View;

public class LottoController {

    public void run(){
        View.requestPurchaseAmount();
        PurchaseAmount purchaseAmount = PurchaseAmount.from(InputService.purchaseAmount());
    }
}
