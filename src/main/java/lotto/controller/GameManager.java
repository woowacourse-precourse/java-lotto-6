package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Calculator;
import lotto.domain.LottoPublisher;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameManager {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoPublisher lottoPublisher = new LottoPublisher();
    private Calculator calculator = new Calculator();

    public void run() {
        Amount amount = inputPurchaseAmountUntilNoError();
        Lottos lottos = publishLottosByAmountAndPrintLottos(amount);
        Lotto winningLotto = inputWinningNumbersUntilNoError();
        Bonus bonus = inputBonusNumbersUntilNoError();
        WinningResult winningResult = getWinningResultAndPrint(lottos, winningLotto, bonus);
        getROIAndPrint(winningResult, amount);
    }

    private Amount inputPurchaseAmountUntilNoError() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Lottos publishLottosByAmountAndPrintLottos(Amount amount) {
        outputView.printLineBreak();
        printLottoCountByAmount(amount);
        Lottos lottos = lottoPublisher.publishLottosByAmount(amount);
        outputView.printPublishedLottos(lottos);
        return lottos;
    }

    private void printLottoCountByAmount(Amount amount) {
        outputView.printPublishedLottoCount(lottoPublisher.getLottoCountByAmount(amount));
    }

    private Lotto inputWinningNumbersUntilNoError() {
        outputView.printLineBreak();
        while (true) {
            try {
                return inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Bonus inputBonusNumbersUntilNoError() {
        outputView.printLineBreak();
        while (true) {
            try {
                return inputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private WinningResult getWinningResultAndPrint(Lottos lottos, Lotto winningLotto, Bonus bonus) {
        outputView.printLineBreak();
        WinningResult winningResult = new WinningResult(
                lottos.determineWinningsCount(winningLotto, bonus));
        outputView.printWinningResult(winningResult);
        return winningResult;
    }

    private void getROIAndPrint(WinningResult winningResult, Amount amount) {
        long prize = winningResult.getTotalLotteryPrize();
        outputView.printROI(calculator.calculateROI(prize, amount));
    }

}
