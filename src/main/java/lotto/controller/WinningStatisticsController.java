package lotto.controller;

import java.util.Map;
import lotto.domain.CalculatingPrizeMoney;
import lotto.domain.ComparingLotto;

public class WinningStatisticsController {

    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String THREE_HYPHEN = "---";
    private static final ComparingLotto comparingLotto = new ComparingLotto();

    public void start() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_HYPHEN);
        Map<Integer, Integer> lottoWinningCounter = comparingLotto.comparingLotto();
        CalculatingPrizeMoney calculatingPrizeMoney = new CalculatingPrizeMoney();
        calculatingPrizeMoney.payPrize(lottoWinningCounter);
        calculatingPrizeMoney.calculate(lottoWinningCounter);
    }

}
