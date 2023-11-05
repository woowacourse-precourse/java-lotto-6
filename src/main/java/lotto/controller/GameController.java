package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.domain.constants.LottoPrizeRule;
import lotto.util.Calculator;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private Money inputMoney;
    private final WinningNumbers winningNumbers = new WinningNumbers();
    private final BonusNumber bonusNumber = new BonusNumber();
    private final LottoIssueController lottoIssueController = new LottoIssueController();
    private final WinningNumberController winningNumberController = new WinningNumberController();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser();

    private String getMoneyInput() {
        outputView.printInputMoneyMessage();
        return inputView.getMoneyInput();
    }

    public void getMoney() {
        try {
            inputMoney = new Money(getMoneyInput());
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            getMoney();
        }
    }

    public Lottos purchaseLottos() {
        Lottos lottos = lottoIssueController.createLottos(inputMoney.getMoney());
        getPurchaseDetails(lottos);
        return lottos;
    }

    private void getPurchaseDetails(Lottos lottos) {
        outputView.printPurchaseDetailsMessage(lottoIssueController.getLottoCount(inputMoney.getMoney()));
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

    private void calculateProfitRate(Lottos lottos) {
        int totalProfit = lottos.getTotalProfit();
        double profitRate = calculator.getProfitRate(totalProfit, inputMoney.getMoney());
        outputView.printProfitRate(parser.doubleToSecondDecimalString(profitRate));
    }

    public void play() {
        getMoney();
        Lottos lottos = purchaseLottos();

        setWinningNumber();

        lottos.calculateWinningStatistics(winningNumbers, bonusNumber);
        getWinningStatistics(lottos);
        calculateProfitRate(lottos);
    }
}
