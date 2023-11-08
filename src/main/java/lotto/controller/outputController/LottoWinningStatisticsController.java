package lotto.controller.outputController;

import lotto.model.lottoResultChecker.LottoRank;
import lotto.view.outputView.LottoWinningStatisticsOutput;
import java.util.Map;

public class LottoWinningStatisticsController {

    private final LottoWinningStatisticsOutput statisticsOutput = new LottoWinningStatisticsOutput();

    public void displayStatistics(Map<LottoRank, Integer> rankResult) {
        statisticsOutput.printStatistics(rankResult);
    }
}