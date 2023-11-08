package lotto.domain;

import java.util.EnumMap;

public class LottoPrizeCount {
    private static EnumMap<LottoPrize, Integer> prizeCounts;

    public LottoPrizeCount() {
        prizeCounts = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCounts.put(prize, 0);
        }
    }

    public static EnumMap<LottoPrize, Integer> calculatePrizes(WinningNumber winningNumber, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchedCount = lotto.countMachedNumber(winningNumber.getWinningNumber());
            boolean containsBonusNumber = lotto.containBonusNumber(winningNumber.getBonusNumber());
            LottoPrize prize = LottoPrize.getPrize(matchedCount, containsBonusNumber);

            prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        }
        return prizeCounts;
    }
}
