package lotto.controller;

import lotto.domain.Lotto;
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
        lottoWinningCalculationOutputView.outputWinningNumber();
        Lotto lotto = winningNumberInputController.inputWinningNumber();

        lottoWinningCalculationOutputView.outputBonusNumber();
        int bonusNumber = winningNumberInputController.inputBonusNumber(lotto);

        WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);

        WinningStatistics winningStatistics = lottoWinningCalculationMachine.calculateWinningStatistics(lottos,
                winningNumber);
        lottoWinningCalculationOutputView.outputWinningStatistics(winningStatistics);
    }
}
