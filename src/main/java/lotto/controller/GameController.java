package lotto.controller;

import lotto.service.NumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberService numberService;

    public GameController(InputView inputView, OutputView outputView, NumberService numberService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberService = numberService;
    }

    public void run() {
        purchaseLottos();
        issueLottos();
        inputWinningLotto();
        inputBonusNumber();
        outputWinningStatistics();
    }

    public void purchaseLottos() {
        String input;
        do {
            outputView.requestPurchaseAmountMessage();
            input = inputView.scanPurchaseAmount();
        } while (isInvalidPurchaseAmount(input));
    }

    public void issueLottos() {
        try {
            numberService.initLottos();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            throw e;
        }
        outputView.printPurchasedNumberMessage(numberService.getPurchaseNumber());
        outputView.printLottos(numberService.getLottosOutput());
    }

    public void inputWinningLotto() {
        numberService.initWinningNumbers();
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

    public void outputWinningStatistics() {
        numberService.initRankStatistics();
        outputView.printRankStatistics(numberService.getRankStatisticsOutput());
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
