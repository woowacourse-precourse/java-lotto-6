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

    public Money createMoney(String playerInput) {
        Money inputMoney;

        try {
            inputMoney = new Money(playerInput);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            inputMoney = getMoney();
        }

        return inputMoney;
    }

    public Money getMoney() {
        String playerInput = getMoneyInput();
        return createMoney(playerInput);
    }

    public Lottos purchaseLottos(Money inputMoney) {
        Lottos lottos = lottoIssueController.createLottos(inputMoney.getMoney());
        getPurchaseDetails(lottos, inputMoney);
        return lottos;
    }

    private void getPurchaseDetails(Lottos lottos, Money inputMoney) {
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

    public void setWinningNumbers() {
        try {
            String inputNumbers = getWinningNumbersInput();
            winningNumberController.setInputToWinningNumbers(winningNumbers, inputNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            setWinningNumbers();
        }
    }

    public void setBonusNumber() {
        try {
            String inputNumber = getBonusNumberInput();
            winningNumberController.setInputToBonusNumber(winningNumbers, bonusNumber, inputNumber);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            setBonusNumber();
        }
    }

    private void getWinningStatistics(Lottos lottos) {
        String winningStatisticsDetails = LottoPrizeRule.getWinningStatisticsMessage(lottos);
        outputView.printWinningStatistics(winningStatisticsDetails);
    }

    private void calculateProfitRate(Lottos lottos, Money inputMoney) {
        int totalProfit = lottos.getTotalProfit();
        double profitRate = calculator.getProfitRate(totalProfit, inputMoney.getMoney());
        outputView.printProfitRate(parser.doubleToSecondDecimalString(profitRate));
    }

    public void play() {
        Money inputMoney = getMoney();
        Lottos lottos = purchaseLottos(inputMoney);

        setWinningNumbers();
        setBonusNumber();

        lottos.calculateWinningStatistics(winningNumbers, bonusNumber);
        getWinningStatistics(lottos);
        calculateProfitRate(lottos, inputMoney);
    }
}
