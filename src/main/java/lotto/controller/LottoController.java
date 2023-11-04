package lotto.controller;

import static lotto.constant.LottoOutputMessage.*;

import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;

    public LottoController() {
        outputView = new OutputView();
    }

    public void run() {
        initPurchaseAmount();
    }

    private void initPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
    }
}
