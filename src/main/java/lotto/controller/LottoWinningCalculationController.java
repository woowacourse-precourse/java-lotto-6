package lotto.controller;

import lotto.domain.LottoWinningCalculationMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStatistics;
import lotto.view.LottoWinningCalculationOutputView;

public class LottoWinningCalculationController {
    private LottoWinningCalculationMachine lottoWinningCalculationMachine;
    private WinningNumberInputController winningNumberInputController;
    private LottoWinningCalculationOutputView lottoWinningCalculationOutputView;

    public LottoWinningCalculationController() {
        lottoWinningCalculationMachine = new LottoWinningCalculationMachine();
        winningNumberInputController = new WinningNumberInputController();
        lottoWinningCalculationOutputView = new LottoWinningCalculationOutputView();
    }

    public void calculateWinningStatistics(Lottos lottos) {
        WinningNumber winningNumber = winningNumberInputController.inputWinningLotto();
        WinningStatistics winningStatistics = lottoWinningCalculationMachine.calculateWinningStatistics(lottos,
                winningNumber);
        lottoWinningCalculationOutputView.outputWinningStatistics(winningStatistics);
    }
}
