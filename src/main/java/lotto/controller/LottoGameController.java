package lotto.controller;

import lotto.service.LottoGameService;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    private int setPurchaseTotalCount() {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                PurchaseAmountValidator.validate(purchaseAmount);
                return Integer.parseInt(purchaseAmount) / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}