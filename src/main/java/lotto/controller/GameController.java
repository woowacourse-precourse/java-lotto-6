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
        issueLotto();
        inputWinningLotto();
        inputBonusNumber();
    }

    public void purchaseLotto() {
        String input;
        do {
            outputView.requestPurchaseAmountMessage();
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
        outputView.printPurchasedNumberMessage(numberService.getPurchaseNumber());
        outputView.printAllLottoNumbers(numberService.getAllLottoNumbersInString());
    }

    public void inputWinningLotto() {
        String input;
        do {
            outputView.requestWinningLottoMessage();
            input = inputView.scanWinningLotto();
        } while (isInvalidWinningLotto(input));
    }

    public void inputBonusNumber() {
        String input;
        do {
            outputView.requestBonusNumberMessage();
            input = inputView.scanBonusNumber();
        } while (isInvalidBonusNumber(input));
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

    private boolean isInvalidWinningLotto(String input) {
        try {
            numberService.initWinningLotto(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return true;
        }
        return false;
    }

    private boolean isInvalidBonusNumber(String input) {
        try {
            numberService.initBonusNumber(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return true;
        }
        return false;
    }
}
