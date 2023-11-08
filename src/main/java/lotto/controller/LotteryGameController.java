package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.LotteryMessageBuilder;
import lotto.domain.lottery.*;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class LotteryGameController {
    static int purchaseAmount;
    static int lottoAmount;
    static Lotto winningLotto;
    static BonusNumber bonusNumber;

    static final Lottos purchasedLotto = new Lottos();
    private final InputView inputView = new InputView();
    private final LotteryMessageBuilder lotteryMessageBuilder = new LotteryMessageBuilder();
    private final Computer computer = new Computer();
    private final PurchaseController purchaseController = new PurchaseController();
    private final WinningNumberController winningNumberController = new WinningNumberController();

    public void run() {
        purchaseController.purchaseStage();
        winningNumberController.inputWinningNumberStage();
        returnLotteryResult(purchaseAmount);
        inputView.closeConsole();
    }

    private void returnLotteryResult(int purchaseAmount) {
        Map<Integer, Integer> winningStats = new HashMap<>();
        computer.checkWinningLotto(purchasedLotto, winningLotto, bonusNumber, winningStats);
        computer.calcRateOfProfit(winningStats, purchaseAmount);
        OutputView.printNewLine();
        OutputView.returnWinningStats(lotteryMessageBuilder.returnWinningLottoList(winningStats));
    }
}
