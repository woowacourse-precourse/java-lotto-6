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
        outputPurchaseAmount(lottoCount);
        String[] lottoResultNumber = InputView.inputLottoResultNumber();
        int bonusNumber = InputView.inputBonusResultNumber();
        LottoResult lottoResult = new LottoResult(lottoResultNumber, bonusNumber);
        WinningStatistics winningStatistics = new WinningStatistics(
                lottoResult.getLottoResultNumber(),
                lottoCount.getLotties(),
                lottoResult.getBonusNumber(),
                purchaseAmount);
        outputResult(winningStatistics);

    }

    private void outputPurchaseAmount(LottoCount lottoCount) {
        OutputView.printLottoCount(lottoCount.getLottoCount());
        OutputView.printLotties(lottoCount.getLotties());
    }

    private void outputResult(WinningStatistics winningStatistics) {
        OutputView.result(winningStatistics.getRanking(),
                winningStatistics.getTotalRanking(),
                winningStatistics.getRateOfReturn());
    }


}
