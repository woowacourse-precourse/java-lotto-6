package lotto.controller;

import static lotto.constant.LottoOutputMessage.*;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController() {
        outputView = new OutputView();
        inputView = new InputView();
        lottoService = new LottoService();
    }

    public void run() {
        String purchaseAmount = initPurchaseAmount();
        lottoService.purchase(purchaseAmount);
    }

    private String initPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
        return inputView.requestPurchaseAmount();
    }
}
