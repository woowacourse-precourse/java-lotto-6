package lotto.service;

import java.util.Map;
import lotto.domain.Prize;
import lotto.view.OutputView;

public class PrizeStatisticService {

    public static int reportPrizeResults(Map<Prize, Integer> prizeCounts) {
        OutputView.printPrizeStaticIntro();
        int totalPrizeMoney = 0;
        for (Map.Entry<Prize, Integer> entry : prizeCounts.entrySet()) {
            Prize prize = entry.getKey();
            Integer count = entry.getValue();

            totalPrizeMoney += calculateWinningPrize(prize, count);
            printPrizeStatistics(prize, count);
        }
        return totalPrizeMoney;
    }

    public static int calculateWinningPrize(Prize prize, int count) {
        return prize.getPrizeAmount() * count;
    }

    public static void printPrizeStatistics(Prize prize, int count) {
        OutputView.printTotalStats(prize, count);
    }


}


