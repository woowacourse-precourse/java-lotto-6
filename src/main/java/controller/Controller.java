package controller;

import domain.LottoCount;
import domain.LottoResult;
import domain.WinningStatistics;
import view.InputView;
import view.OutputView;

public class Controller {
    public void run() {

        int purchaseAmount = InputView.purchaseAmount();
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        OutputView.printLottoCount(lottoCount.getLottoCount());
        OutputView.printLotties(lottoCount.getLotties());

        String[] lottoResultNumber = InputView.inputLottoResultNumber();
        String bonusNumber = InputView.inputBonusResultNumber();
        LottoResult lottoResult = new LottoResult(lottoResultNumber, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics(
                lottoResult.getLottoResultNumber(),
                lottoCount.getLotties(),
                lottoResult.getBonusNumber(),
                purchaseAmount);
        OutputView.result(winningStatistics.getRanking(),
                winningStatistics.getTotalRanking(),
                winningStatistics.getRateOfReturn());
    }


}
