package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.TotalProfitCalculator;
import lotto.model.WinningNumbers;
import lotto.view.input.InputView;
import lotto.view.input.WinningNumbersInputView;
import lotto.view.output.OutputView;

import java.util.List;

public class LottoGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoMachine lottoMachine;
    private WinningNumbersInputView winningNumbersInputView;
    private LottoStatistics lottoStatistics;
    private WinningNumbers winningNumbers;
    private TotalProfitCalculator totalProfitCalculator;

    public void start() {
        int payment = inputMoney();
        outputPurchaseLottoInformation(payment);
        List<Integer> numbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        outputWinningStatistics(numbers, bonusNumber);
        outputTotalProfit(payment);
    }

    private int inputMoney() {
        return inputView.getPurchaseAmount();
    }

    private void outputPurchaseLottoInformation(int payment) {
        lottoMachine = new LottoMachine(payment);
        outputView.showLottos(lottoMachine.getNumberOfLottoTickets(), lottoMachine.getLottos());
    }

    private List<Integer> inputWinningNumbers() {
        winningNumbersInputView = new WinningNumbersInputView();
        return winningNumbersInputView.getInput();
    }

    private int inputBonusNumber() {
        return inputView.getBonusNumber();
    }

    private void outputWinningStatistics(List<Integer> numbers, int bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
        lottoStatistics = new LottoStatistics(lottoMachine.getLottos(), winningNumbers);
        lottoStatistics.compareLottosWithWinningNumbers();
        outputView.showWinningStatistics(lottoStatistics);
    }

    private void outputTotalProfit(int payment) {
        totalProfitCalculator = new TotalProfitCalculator(lottoStatistics, payment);
        outputView.showTotalProfit(totalProfitCalculator.calculateTotalProfit(lottoStatistics));
    }
}
