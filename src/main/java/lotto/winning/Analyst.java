package lotto.winning;

import static lotto.Settings.MAIN_MATCH_FOR_FIFTH;
import static lotto.Settings.MAIN_MATCH_FOR_FIRST;
import static lotto.Settings.MAIN_MATCH_FOR_FOURTH;
import static lotto.Settings.MAIN_MATCH_FOR_SECOND;
import static lotto.Settings.MAIN_MATCH_FOR_THIRD;
import static lotto.winning.Prize.FIFTH;
import static lotto.winning.Prize.FIRST;
import static lotto.winning.Prize.FOURTH;
import static lotto.winning.Prize.SECOND;
import static lotto.winning.Prize.THIRD;
import static lotto.winning.Tally.AMOUNT;
import static lotto.winning.Tally.COUNT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyst {

    public double calculateReturnRatio(HashMap<Prize, HashMap<Tally, Integer>> updatedPrizes, int totalPurchase) {
        int totalPrize = updatedPrizes.values().stream().mapToInt(map -> map.get(AMOUNT)).sum();

        double returnRatio = ((double) totalPrize / totalPurchase) * 100;

        return new BigDecimal(returnRatio).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public HashMap<Prize, HashMap<Tally, Integer>> updatePrizes(List<Integer> winningNumberMatchCounts,
                                                                List<Integer> bonusNumberMatchCounts) {

        HashMap<Prize, HashMap<Tally, Integer>> updatedPrizes = createDefaultPrizes();

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

    private void updatePrize(HashMap<Tally, Integer> updatedPrize, Prize prize) {
        updatedPrize.put(COUNT, updatedPrize.get(COUNT) + 1);
        updatedPrize.put(AMOUNT, updatedPrize.get(AMOUNT) + prize.getPrize());
    }

    private Prize determinePrizeRank(int winningMatchCount, int bonusMatchCount) {
        Prize rank = null;

        if (winningMatchCount == MAIN_MATCH_FOR_FIRST.getNumber())
            rank = FIRST;
        if (winningMatchCount == MAIN_MATCH_FOR_SECOND.getNumber() && bonusMatchCount > 0)
            rank = SECOND;
        if (winningMatchCount == MAIN_MATCH_FOR_THIRD.getNumber() && bonusMatchCount == 0)
            rank = THIRD;
        if (winningMatchCount == MAIN_MATCH_FOR_FOURTH.getNumber())
            rank = FOURTH;
        if (winningMatchCount == MAIN_MATCH_FOR_FIFTH.getNumber())
            rank = FIFTH;

        return rank;
    }

    private HashMap<Prize, HashMap<Tally, Integer>> createDefaultPrizes() {
        HashMap<Prize, HashMap<Tally, Integer>> defaultPrizeTable = new HashMap<>();

        for (int value = 0; value < Prize.values().length; value++) {
            defaultPrizeTable.put(Prize.values()[value], new HashMap<>(Map.of(COUNT, 0, AMOUNT, 0)));
        }

        return defaultPrizeTable;
    }
}
