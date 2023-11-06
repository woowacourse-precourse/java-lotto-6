package lotto.controller;

import lotto.domain.LottoAnalyzer;
import lotto.domain.LottoVendingMachine;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private final LottoVendingMachine lottoVendingMachine;

    public GameController() {
        lottoVendingMachine = new LottoVendingMachine();
    }

    public void play() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        lottoVendingMachine.purchaseLotto(purchaseAmount);
        OutputView.printLottoTicketNumber(lottoVendingMachine.getLottoTicketNumber());
        OutputView.printPurchasedLottoTickets(lottoVendingMachine.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        LottoAnalyzer lottoAnalyzer = inputBonusNumber(winningNumbers);

        WinningStatistics winningStatistics = new WinningStatistics(lottoAnalyzer);
        winningStatistics.analyzeLotto(lottoVendingMachine.getLottos());

        OutputView.printFinalResult(winningStatistics.getWinningStatistics());
        OutputView.printTotalProfitRate(winningStatistics.getWinningStatistics(), purchaseAmount);
    }

    private static LottoAnalyzer inputBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = InputView.inputBonusNumber();
        try {
            return new LottoAnalyzer(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
