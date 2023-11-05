package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Prizes {
    private Map<Prize, Integer> prizes;

    private Prizes(final Map<Prize, Integer> prizes) {
        this.prizes = prizes;
    }

    public static Prizes createPrizes() {
        final Map<Prize, Integer> prizes = new EnumMap<Prize, Integer>(Prize.class);
        initPrizes(prizes);

        return new Prizes(prizes);
    }

    private static void initPrizes(final Map<Prize, Integer> prizes) {
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    public void increasePrizeAmount(Prize prize) {
        int prizeAmount = getPrizeAmount(prize);

        prizes.put(prize, ++prizeAmount);
    }

    public int calculateTotalPrizeForRank(Prize prize) {
        int prizeMoney = prize.getPrizeMoney();
        int prizeAmount = getPrizeAmount(prize);
        int totalPrizeForRank = prizeMoney * prizeAmount;

        return totalPrizeForRank;
    }

    public int getPrizeAmount(Prize prize) {
        return prizes.getOrDefault(prize, 0);
    }

    public int calculateTotalPrize() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> calculateTotalPrizeForRank(prize))
                .sum();
    }
}
