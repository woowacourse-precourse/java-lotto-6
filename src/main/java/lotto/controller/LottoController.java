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
        Integer purchaseCount = initPurchaseAmount();
        lottoService.purchase(purchaseCount);
    }

    private Integer initPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmountInput = requestPurchaseAmount();
                return lottoService.validatePurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private String requestPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
        return inputView.requestPurchaseAmount();
    }
}
