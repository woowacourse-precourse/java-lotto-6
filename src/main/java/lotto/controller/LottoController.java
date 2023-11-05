package lotto.controller;

import lotto.validator.InputPurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputPurchaseAmountValidator purchaseAmountValidator;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView(this.outputView);
        this.purchaseAmountValidator = new InputPurchaseAmountValidator();
    }

    public void play() {
        String purchaseAmount = "";
        boolean checkValid = false;

        while (!checkValid) {
            try {
                purchaseAmount = receivePurchaseAmount();
                purchaseAmountValidator.validate(purchaseAmount);
                checkValid = true;
            } catch (IllegalArgumentException e) {
                outputView.printInputErrorMessage(e.getMessage());
            }
        }
    }

    private String receivePurchaseAmount() {
        return inputView.receivePurchaseAmountInput();
    }

}
