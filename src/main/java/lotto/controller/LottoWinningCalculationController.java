package lotto.controller;

import lotto.domain.LottoWinningCalculationMachine;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
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

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        WinningStatistics winningStatistics
                = lottoWinningCalculationMachine.calculateWinningStatistics(lottos, winningLotto);
        lottoWinningCalculationOutputView.outputWinningStatistics(winningStatistics);
    }
}
