package lotto.controller;

import lotto.validator.InputPurchaseAmountValidator;
import lotto.view.InputPreprocessor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputPurchaseAmountValidator purchaseAmountValidator;
    private final InputPreprocessor preprocessor;
    private static final int LOTTO_PRICE = 1000;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView(this.outputView);
        this.purchaseAmountValidator = new InputPurchaseAmountValidator();
        this.preprocessor = new InputPreprocessor();
    }

    public void play() {
        String purchaseAmount = getValidatedPurchaseAmount();
    }

    private String getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = receivePurchaseAmount();
                input = trimInput(input);
                purchaseAmountValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printInputErrorMessage(e.getMessage());
            }
        }
    }

    private String receivePurchaseAmount() {
        return inputView.receivePurchaseAmountInput();
    }

    private String trimInput(String input) {
        return preprocessor.trimInput(input);
    }

}
