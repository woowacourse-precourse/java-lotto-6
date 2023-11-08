package lotto.util;

import lotto.domain.Prize;
import lotto.domain.Lotto;
import org.assertj.core.util.VisibleForTesting;

import java.util.List;

public class StatisticsUtils {
    private static final int PRIZE_TARGET_LEVEL = 5;
    private static final Prize[] prizes = new Prize[PRIZE_TARGET_LEVEL];

    public static double calculateReturnRate(int buyAmount, long totalReturn) {
        return totalReturn / (double) buyAmount * 100.0;
    }

    private static void initializePrizes() {
        prizes[0] = new Prize(3, 5000);
        prizes[1] = new Prize(4, 50000);
        prizes[2] = new Prize(5, 1500000);
        prizes[3] = new Prize(5, 30000000);
        prizes[4] = new Prize(6, 2000000000);
    }

    public static Prize[] calculatePrize(Lotto prizeLotto, List<Lotto> lottos, int bonusNumber) {
        initializePrizes();
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchingCount(prizeLotto, lotto);

            if (matchCount == 3)
                prizes[0].increaseMatchedCount();
            if (matchCount == 4)
                prizes[1].increaseMatchedCount();
            if (matchCount == 5)
                prizes[2].increaseMatchedCount();
            if (matchCount == 5 && isMatchBonusNumber(lotto, bonusNumber))
                prizes[3].increaseMatchedCount();
            if (matchCount == 6)
                prizes[4].increaseMatchedCount();
        }
        return prizes;
    }

    @VisibleForTesting
    protected static boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    @VisibleForTesting
    protected static int calculateMatchingCount(Lotto prize, Lotto userLotto) {
        return (int) prize.getNumbers().stream()
                .filter(userLotto.getNumbers()::contains)
                .count();
    }

    public static long calculateTotalReturn(Prize[] prizes) {
        long sum = 0;

        for (Prize prize : prizes) {
            sum += prize.getPrizeAmount() * prize.getMatchedCount();
        }
        return sum;
    }
}
