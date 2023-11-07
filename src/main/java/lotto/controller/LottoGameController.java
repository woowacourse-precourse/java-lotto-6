package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.TotalProfitCalculator;
import lotto.model.WinningNumbers;
import lotto.util.NumberValidator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.List;

public class LottoGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoMachine lottoMachine;
    private LottoStatistics lottoStatistics;
    private WinningNumbers winningNumbers;
    private TotalProfitCalculator totalProfitCalculator;

    public void start() {
        int payment = inputMoney();
        outputPurchaseLottoInformation(payment);
        List<Integer> numbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(numbers);
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
        return inputView.getWinningNumbers();
    }

    private int inputBonusNumber(List<Integer> numbers) {
        try{
            int bonusNumber = inputView.getBonusNumber();
            NumberValidator.isWinningNumberDuplicate(bonusNumber, numbers);
            return bonusNumber;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputBonusNumber(numbers);
    }

    private void outputWinningStatistics(List<Integer> numbers, int bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
        lottoStatistics = new LottoStatistics(lottoMachine.getLottos(), winningNumbers);
        lottoStatistics.compareLottosWithWinningNumbers();
        outputView.showWinningStatistics(lottoStatistics);
    }

    private void outputTotalProfit(int payment) {
        totalProfitCalculator = new TotalProfitCalculator(payment);
        outputView.showTotalProfit(totalProfitCalculator.calculateTotalProfit(lottoStatistics));
    }
}
