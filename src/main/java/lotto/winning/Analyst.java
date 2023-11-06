package lotto.winning;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Analyst {
    private static final int COUNT = PrizeIndex.COUNT.getNumber();
    private static final int PRIZE = PrizeIndex.PRIZE.getNumber();

    public double calculateReturnRatio(HashMap<Prize, List<Integer>> updatedPrizes, int totalPurchase) {
        int totalPrize = updatedPrizes.values().stream().mapToInt(list -> list.get(PRIZE)).sum();

        double returnRatio = ((double) totalPrize / totalPurchase) * 100;

        return new BigDecimal(returnRatio).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public HashMap<Prize, List<Integer>> updatePrizes(List<Integer> winningNumberMatchCounts, List<Integer> bonusNumberMatchCounts) {
        HashMap<Prize, List<Integer>> updatedPrizes = createDefaultPrizes();

        for (int i = 0; i < winningNumberMatchCounts.size(); i++) {
            int winningMatchCount = winningNumberMatchCounts.get(i);
            int bonusMatchCount = bonusNumberMatchCounts.get(i);

            Prize prize = determinePrizeRank(winningMatchCount, bonusMatchCount);
            if (prize != null) {
                updatePrize(updatedPrizes.get(prize), prize);
            }
        }

        return updatedPrizes;
    }

    private void updatePrize(List<Integer> prize, Prize prizeAmount) {
        prize.set(COUNT, prize.get(COUNT) + 1);
        prize.set(PRIZE, prize.get(PRIZE) + prizeAmount.getPrize());
    }

    private Prize determinePrizeRank(int winningMatchCount, int bonusMatchCount) {
        switch (winningMatchCount) {
            case 6:
                return Prize.FIRST;
            case 5:
                if (bonusMatchCount > 0) {
                    return Prize.SECOND;
                }
                if (bonusMatchCount == 0) {
                    return Prize.THIRD;
                }
            case 4:
                return Prize.FOURTH;
            case 3:
                return Prize.FIFTH;
            default:
                return null;
        }
    }

    private HashMap<Prize, List<Integer>> createDefaultPrizes() {
        HashMap<Prize, List<Integer>> defaultPrizeTable = new HashMap<>();

        for (int value = 0; value < Prize.values().length; value++) {
            defaultPrizeTable.put(Prize.values()[value], Arrays.asList(0, 0));
        }

        return defaultPrizeTable;
    }
}
