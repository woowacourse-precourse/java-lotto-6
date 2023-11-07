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

    // 구입 금액을 입력받는 메서드
    public int inputPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

    // 입력된 구입 금액을 기반으로 로또 티켓을 생성하는 메서드
    public List<Lotto> generateLottoTickets(int purchaseAmount) {
        return lottoMachine.generateLottoTickets(purchaseAmount);
    }

    // 당첨 번호를 입력받는 메서드
    public List<Integer> inputWinningNumbers() {
        return inputView.inputWinningNumbers();
    }

    // 보너스 볼을 입력받는 메서드
    public int inputBonusNumber(List<Integer> winningNumbers) {
        return inputView.inputBonusNumber(winningNumbers);
    }

    // 당첨 결과를 계산하는 메서드
    public WinningResult calculateWinningResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        return lottoMachine.calculateWinningResult(lottoTickets, winningNumbers, bonusNumber);
    }

    // 게임의 결과를 출력하는 메서드
    public void showResult(List<Lotto> lottoTickets, WinningResult winningResult) {
        ResultView.showPurchasedLottoTickets(lottoTickets);
        ResultView.showWinningResult(winningResult);
        double earningRate = calculateEarningRate(winningResult.getTotalPrize(), lottoTickets.size());
        ResultView.showEarningRate(earningRate);
    }

    // 수익률을 계산하는 메서드
    public double calculateEarningRate(int totalPrize, int ticketCount) {
        if (ticketCount == 0) {
            return 0.0;
        }
        return (double) totalPrize / (ticketCount * 1000);
    }
}
