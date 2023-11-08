package lotto.domain.prize;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningDetails {
    private final Map<Prize, Integer> winningDetails;

    private WinningDetails(final Map<Prize, Integer> winningDetails) {
        this.winningDetails = winningDetails;
    }

    public static WinningDetails createWinningDetails() {
        final Map<Prize, Integer> winningDetails = new EnumMap<Prize, Integer>(Prize.class);
        initWinningDetails(winningDetails);

        return new WinningDetails(winningDetails);
    }

    private static void initWinningDetails(final Map<Prize, Integer> prizes) {
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    public void increasePrizeAmount(Prize prize) {
        int prizeAmount = getPrizeAmount(prize);

        winningDetails.put(prize, ++prizeAmount);
    }

    public int calculateTotalPrizeForRank(Prize prize) {
        int prizeMoney = prize.getPrizeMoney();
        int prizeAmount = getPrizeAmount(prize);
        int totalPrizeForRank = prizeMoney * prizeAmount;

        return totalPrizeForRank;
    }

    public int calculateTotalPrize() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> calculateTotalPrizeForRank(prize))
                .sum();
    }

    public int getPrizeAmount(Prize prize) {
        return winningDetails.getOrDefault(prize, 0);
    }
}
