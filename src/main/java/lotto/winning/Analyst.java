package lotto.winning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Analyst {
    private static final int COUNT = PrizeIndex.COUNT.getNumber();
    private static final int PRIZE = PrizeIndex.PRIZE.getNumber();

    public HashMap<String, List<Integer>> updatePrizes(List<Integer> winningNumberMatchCounts, List<Integer> bonusNumberMatchCounts) {
        HashMap<String, List<Integer>> updatedPrizes = createDefaultPrizes();

        for (int i = 0; i < winningNumberMatchCounts.size(); i++) {
            int winningMatchCount = winningNumberMatchCounts.get(i);
            int bonusMatchCount = bonusNumberMatchCounts.get(i);

            if (winningMatchCount == 6) {
                List<Integer> updatedPrize = updatedPrizes.get("first");
                updatedPrize.set(COUNT, updatedPrize.get(COUNT) + 1);
                updatedPrize.set(PRIZE, updatedPrize.get(PRIZE) + PrizeIndex.FIRST.getNumber());
            }
            if (winningMatchCount == 5 && bonusMatchCount > 0) {
                List<Integer> updatedPrize = updatedPrizes.get("second");
                updatedPrize.set(COUNT, updatedPrize.get(COUNT) + 1);
                updatedPrize.set(PRIZE, updatedPrize.get(PRIZE) + PrizeIndex.SECOND.getNumber());
            }
            if (winningMatchCount == 5 && bonusMatchCount == 0) {
                List<Integer> updatedPrize = updatedPrizes.get("third");
                updatedPrize.set(COUNT, updatedPrize.get(COUNT) + 1);
                updatedPrize.set(PRIZE, updatedPrize.get(PRIZE) + PrizeIndex.THIRD.getNumber());
            }
            if (winningMatchCount == 4) {
                List<Integer> updatedPrize = updatedPrizes.get("fourth");
                updatedPrize.set(COUNT, updatedPrize.get(COUNT) + 1);
                updatedPrize.set(PRIZE, updatedPrize.get(PRIZE) + PrizeIndex.FOURTH.getNumber());
            }
            if (winningMatchCount == 3) {
                List<Integer> updatedPrize = updatedPrizes.get("fifth");
                updatedPrize.set(COUNT, updatedPrize.get(COUNT) + 1);
                updatedPrize.set(PRIZE, updatedPrize.get(PRIZE) + PrizeIndex.FIFTH.getNumber());
            }
        }

        return updatedPrizes;
    }

    private HashMap<String, List<Integer>> createDefaultPrizes() {
        HashMap<String, List<Integer>> defaultPrizeTable = new HashMap<>();
        defaultPrizeTable.put("first", Arrays.asList(0, 0));
        defaultPrizeTable.put("second", Arrays.asList(0, 0));
        defaultPrizeTable.put("third", Arrays.asList(0, 0));
        defaultPrizeTable.put("fourth", Arrays.asList(0, 0));
        defaultPrizeTable.put("fifth", Arrays.asList(0, 0));

        return defaultPrizeTable;
    }
}
