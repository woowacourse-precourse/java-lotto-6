package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.utils.Rank;

public class Result {
    private final Map<Rank, Integer> result;

    public Result() {
        result = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
            .forEach(rank -> result.put(rank, 0));
    }

    public void increaseRankCount(int matchCount, boolean isContainBonusNumber) {
        Rank rank = Rank.getRank(matchCount, isContainBonusNumber);
        result.put(rank, result.get(rank) + 1);
    }

    public double calculateBenefitRate(Amount amount) {
        long totalPrize = calculateTotalPrize();
        return amount.getBenefitRate(totalPrize);
    }

    private long calculateTotalPrize() {
        return result.keySet()
            .stream()
            .mapToLong(rank -> (long) rank.getPrize() * result.get(rank))
            .sum();
    }

    public Map<Rank, Integer> getResult() {
        Map<Rank, Integer> forReturn = new EnumMap<>(Rank.class);
        for (Rank rank : result.keySet()) {
            forReturn.put(rank, result.get(rank));
        }
        forReturn.remove(Rank.NONE);
        return forReturn;
    }
}
