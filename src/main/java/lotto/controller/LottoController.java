package lotto.controller;

import lotto.utils.PurchasePriceValidator;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int purchasePrice = getPurchasePrice();
    }

    private int getPurchasePrice() {
        String input = inputView.getPurchasePrice();
        PurchasePriceValidator.validIsInt(input);
        return Integer.parseInt(input);
    }

}
