package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.view.OutputView;

public class PrizeStatisticService {

    public static Map<Prize, Integer> initializePrizeStatistics() {
        Map<Prize, Integer> initialStatistics = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                initialStatistics.put(prize, 0);
            }
        }
        return initialStatistics;
    }

    public static Map<Prize, Integer> compilePrizeStatistics(Lotto winningLotto, int bonusNumber) {
        Map<Prize, Integer> matchNumberCount = initializePrizeStatistics();

        // 상금의 수를 맵에 넣어주기
        for (Lotto lottoGame : LottoTicket.lottoGames) {
            LottoResult lottoResult = new LottoResult(lottoGame, winningLotto, bonusNumber);
            LottoResult.updateMatchNumberCount(matchNumberCount, lottoResult);
        }

        return matchNumberCount;
    }

    public static int processAndReportPrizeResults(Map<Prize, Integer> prizeCounts) {
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


