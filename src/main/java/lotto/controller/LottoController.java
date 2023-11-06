package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final InputView inputView;

    public LottoController(LottoMachine lottoMachine, InputView inputView) {
        this.lottoMachine = lottoMachine;
        this.inputView = inputView;
    }

    public int inputPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

    public List<Lotto> generateLottoTickets(int purchaseAmount) {
        return lottoMachine.generateLottoTickets(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        return inputView.inputWinningNumbers();
    }

    public int inputBonusNumber() {
        return inputView.inputBonusNumber();
    }

    public WinningResult calculateWinningResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        return lottoMachine.calculateWinningResult(lottoTickets, winningNumbers, bonusNumber);
    }

    public void showResult(List<Lotto> lottoTickets, WinningResult winningResult) {
        ResultView.showPurchasedLottoTickets(lottoTickets);
        ResultView.showWinningResult(winningResult);
        double earningRate = calculateEarningRate(winningResult.getTotalPrize(), lottoTickets.size());
        ResultView.showEarningRate(earningRate);
    }

    private double calculateEarningRate(int totalPrize, int ticketCount) {
        if (ticketCount == 0) {
            return 0.0;
        }
        return (double) totalPrize / (ticketCount * 1000);
    }
}
