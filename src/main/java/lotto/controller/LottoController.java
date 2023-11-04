package lotto.controller;

import static lotto.constant.LottoOutputMessage.*;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        String purchaseAmount = initPurchaseAmount();
    }

    private String initPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
        return inputView.requestPurchaseAmount();
    }
}
