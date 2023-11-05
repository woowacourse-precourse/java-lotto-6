package lotto.controller;

import lotto.validator.InputPurchaseAmountValidator;
import lotto.view.InputConverter;
import lotto.view.InputPreprocessor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputPurchaseAmountValidator purchaseAmountValidator;
    private final InputPreprocessor preprocessor;
    private final InputConverter converter;
    private static final int LOTTO_PRICE = 1000;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView(this.outputView);
        this.purchaseAmountValidator = new InputPurchaseAmountValidator();
        this.preprocessor = new InputPreprocessor();
        this.converter = new InputConverter();
    }

    public void play() {
        int purchaseAmount = getValidatedPurchaseAmount();
    }

    private int getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = receivePurchaseAmount();
                input = trimInput(input);
                purchaseAmountValidator.validate(input);
                return converter.convertToInteger(input);
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
