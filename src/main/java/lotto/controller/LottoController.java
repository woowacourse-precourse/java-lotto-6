package lotto.controller;

import lotto.dto.PurchaseAmountRequest;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView view;

    public LottoController(LottoView lottoView) {
        this.view = lottoView;
    }

    public void run() {
        PurchaseAmountRequest purchaseAmountRequest = view.readPurchaseAmount();
    }
}
