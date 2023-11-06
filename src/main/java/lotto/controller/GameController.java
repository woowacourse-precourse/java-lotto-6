package lotto.controller;

import lotto.service.NumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private NumberService numberService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberService = new NumberService();
    }

    public void run() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        String input;
        do {
            outputView.printPurchaseAmountMessage();
            input = inputView.scanPurchaseAmount();
        } while (isInvalidPurchaseAmount(input));
    }

    private boolean isInvalidPurchaseAmount(String input) {
        try {
            numberService.createPurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return true;
        }
        return false;
    }
}
