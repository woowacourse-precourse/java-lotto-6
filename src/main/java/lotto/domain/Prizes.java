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
        int prizeAmount = prizes.getOrDefault(prize, 0);

        prizes.put(prize, ++prizeAmount);
    }

    public int calculateTotalPrizeForRank() {
        return 0;
    }

    public int calculateTotalPrize() {
        return 0;
    }
}
