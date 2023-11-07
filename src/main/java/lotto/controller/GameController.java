package lotto.controller;

import lotto.domain.RandomLottoGenerator;
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
        this.numberService = new NumberService(new RandomLottoGenerator());
    }

    public void run() {
        purchaseLotto();
        issueLotto();
    }

    public void purchaseLotto() {
        String input;
        do {
            outputView.printPurchaseAmountMessage();
            input = inputView.scanPurchaseAmount();
        } while (isInvalidPurchaseAmount(input));
    }

    public void issueLotto() {
        try {
            numberService.initAllLottoNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            throw e;
        }
        outputView.printPurchasedNumberMessage(numberService.getPurchasedNumber());
        outputView.printAllLottoNumbers(numberService.getAllLottoNumbersInString());
    }

    private boolean isInvalidPurchaseAmount(String input) {
        try {
            numberService.initPurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return true;
        }
        return false;
    }
}
