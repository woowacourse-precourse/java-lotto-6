package lotto.controller;

import lotto.model.Message;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    InputView inputView;
    OutputView outputView;
    LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        String lottoCount = enterMoney();
        makeLotto(lottoCount);
        enterWinningLotto();
        enterBonusNumber();
        printResult();
    }

    private void printResult() {
        printStatistics();
        printTotalYield();
    }

    private void printStatistics() {
        printMessage(Message.STATISTICS.toString());
        printMessage(lottoGameService.calculateStatistics());
    }

    private void printTotalYield() {
        printMessage(Message.TOTAL_YIELD.toString(), lottoGameService.calculateTotalYield());
    }

    private void enterBonusNumber() {
        printMessage(Message.ASK_BONUS_NUMBER.toString());
        String bonusNumber = inputView.inputWinningLotto();
        lottoGameService.makeBonusNumber(bonusNumber);
    }

    private void enterWinningLotto() {
        printMessage(Message.ASK_WINNING_LOTTO.toString());
        String winningLotto = inputView.inputWinningLotto();
        lottoGameService.makeWinningLotto(winningLotto);
    }

    private void makeLotto(String lottoCount) {
        printMessage("\n" + lottoCount + Message.LOTTO_COUNT);
        String lotto = lottoGameService.makeLotto();
        printMessage(lotto);
    }

    private String enterMoney() {
        printMessage(Message.ASK_MONEY.toString());
        String lottoCount = null;
        try {
            lottoCount = lottoGameService.buyLotto(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            enterMoney();
        }
        return lottoCount;
    }

    private void printMessage(String message) {
        outputView.printMessage(message);
    }

    private void printMessage(String message, Object... args) {
        outputView.printfMessage(message, args);
    }
}
