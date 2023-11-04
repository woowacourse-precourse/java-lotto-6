package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.constants.LottoPrizeRule;
import lotto.domain.constants.OutputViewMessage;
import lotto.util.Calculator;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private final WinningNumbers winningNumbers = new WinningNumbers();
    private final BonusNumber bonusNumber = new BonusNumber();
    private final LottoIssueController lottoIssueController = new LottoIssueController();
    private final WinningNumberController winningNumberController = new WinningNumberController();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser();

    private int getMoneyInput() {
        outputView.printInputMoneyMessage();
        return inputView.getMoney();
    }

    public Lottos purchaseLottos(int inputMoney) {
        Lottos lottos = lottoIssueController.createLottos(inputMoney);
        getPurchaseDetails(inputMoney, lottos);
        return lottos;
    }

    private void getPurchaseDetails(int inputMoney, Lottos lottos) {
        outputView.printPurchaseDetailsMessage(lottoIssueController.getLottoCount(inputMoney));
        outputView.printPurchasedLottos(lottos.getPurchaseDetails());
    }

    private String getWinningNumbersInput() {
        outputView.printInputWinningNumbersMessage();
        return inputView.getWinningNumbersInput();
    }

    private String getBonusNumberInput() {
        outputView.printInputBonusNumberMessage();
        return inputView.getBonusNumberInput();
    }

    public void setWinningNumber() {
        String inputNumbers = getWinningNumbersInput();
        winningNumberController.setInputToWinningNumbers(winningNumbers, inputNumbers);

        String inputNumber = getBonusNumberInput();
        winningNumberController.setInputToBonusNumber(bonusNumber, inputNumber);
    }

    private void getWinningStatistics(Lottos lottos) {
        String winningStatisticsDetails = LottoPrizeRule.getWinningStatisticsMessage(lottos);
        outputView.printWinningStatistics(winningStatisticsDetails);
    }


    private void calculateProfitRate(Lottos lottos, int inputMoney) {
        int totalProfit = lottos.getTotalProfit();
        double profitRate = calculator.getProfitRate(totalProfit, inputMoney);
        outputView.printProfitRate(parser.doubleToSecondDecimalString(profitRate));
    }

    public void play() {
        int inputMoney = getMoneyInput();
        Lottos lottos = purchaseLottos(inputMoney);

        setWinningNumber();

        lottos.calculateWinningStatistics(winningNumbers, bonusNumber);
        getWinningStatistics(lottos);
        calculateProfitRate(lottos, inputMoney);
    }
}
