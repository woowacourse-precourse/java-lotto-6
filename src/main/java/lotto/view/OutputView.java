package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.utils.Constants.COUNT;
import static lotto.utils.Constants.WINNING_PRIZE_STATISTICS;

public class OutputView {

    public void getStatistic(Buyer buyer, Winning winning) {
        System.out.println(WINNING_PRIZE_STATISTICS);
        int totalPrize = 0;
        List<Lotto> lottos = buyer.getLotto();
        Lotto winningLotto = winning.getLotto();
        int bonus = winning.getBonus();
        Map<Prize, Integer> statistics = new HashMap<>();

        for (Prize prize : Prize.values()) {
            statistics.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningLotto);
            boolean bonusMatch = isBonusMatch(lotto, bonus);

            Prize prize = calculateWinningPrize(matchCount, bonusMatch);
            if (prize != null) {
                statistics.put(prize, statistics.get(prize) + 1);
                totalPrize += prize.getPrizeAmount();
            }
        }
        for (Prize prize : Prize.values()) {
            int count = statistics.get(prize);
            System.out.println(prize.getDescription() + count + COUNT);
        }
        buyer.totalEarning(totalPrize);
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

    private Prize calculateWinningPrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return Prize.SIX_MATCH;
        } else if (matchCount == 5 && bonusMatch) {
            return Prize.FIVE_MATCH_BONUS;
        } else if (matchCount == 5) {
            return Prize.FIVE_MATCH;
        } else if (matchCount == 4) {
            return Prize.FOUR_MATCH;
        } else if (matchCount == 3) {
            return Prize.THREE_MATCH;
        }
        return null;
    }

    public void earningRatio(Buyer buyer) {
        float profitRate = (float) buyer.getEarningPrize() / buyer.getPayment() * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
