package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Prize.matchPrize;
import static lotto.utils.Constants.*;

public class OutputView {

    public void getStatistic(Buyer buyer, Winning winning) {
        System.out.println(WINNING_PRIZE_STATISTICS);
        int totalPrize = 0;
        Map<Prize, Integer> statistics = setupStatistics();
        totalPrize = getTotalPrize(buyer.getLotto(), winning.getLotto(), winning.getBonus(), statistics, totalPrize);
        printStatistics(statistics);
        buyer.totalEarning(totalPrize);
    }

    private static Map<Prize, Integer> setupStatistics() {
        Map<Prize, Integer> statistics = new HashMap<>();

        for (Prize prize : Prize.values()) {
            statistics.put(prize, 0);
        }
        return statistics;
    }

    private int getTotalPrize(List<Lotto> lottos, Lotto winningLotto, int bonus, Map<Prize, Integer> statistics, int totalPrize) {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningLotto);
            boolean bonusMatch = isBonusMatch(lotto, bonus);
            totalPrize = calculateStatistics(statistics, totalPrize, matchCount, bonusMatch);
        }
        return totalPrize;
    }

    private static int calculateStatistics(Map<Prize, Integer> statistics, int totalPrize, int matchCount, boolean bonusMatch) {
        Prize prize = matchPrize(matchCount, bonusMatch);
        if (prize != null) {
            statistics.put(prize, statistics.get(prize) + 1);
            totalPrize += prize.getPrizeAmount();
        }
        return totalPrize;
    }

    private static void printStatistics(Map<Prize, Integer> statistics) {
        for (Prize prize : Prize.values()) {
            int count = statistics.get(prize);
            System.out.println(prize.getDescription() + count + COUNT);
        }
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        long count = lottoNumbers.stream().filter(winningNumbers::contains).count();
        return (int) count;
    }

    private boolean isBonusMatch(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }

    public void earningRatio(Buyer buyer) {
        float profitRate = (float) buyer.getEarningPrize() / buyer.getPayment() * 100;
        System.out.printf(FINAL_EARNING_RATIO, profitRate);
    }
}
