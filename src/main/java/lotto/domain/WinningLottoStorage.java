package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningLottoStorage {

    private final Map<Rank, Integer> rankStorage;

    public WinningLottoStorage() {
        rankStorage = new HashMap<>();
        initRankStorage();
    }

    private void initRankStorage() {
        rankStorage.put(Rank.CORRECT_ZERO, 0);
        rankStorage.put(Rank.CORRECT_ONE, 0);
        rankStorage.put(Rank.CORRECT_TWO, 0);
        rankStorage.put(Rank.CORRECT_THREE, 0);
        rankStorage.put(Rank.CORRECT_FOUR, 0);
        rankStorage.put(Rank.CORRECT_FIVE, 0);
        rankStorage.put(Rank.CORRECT_FIVE_BONUS, 0);
        rankStorage.put(Rank.CORRECT_SIX, 0);
    }

    public void store(Rank rank) {
        Integer count = rankStorage.get(rank);
        rankStorage.put(rank, count + 1);
    }

    public int getRank(Rank rank) {
        return rankStorage.get(rank);
    }

    public double getRateOfReturn(int purchaseAmount) {
        return Math.round(calculateWinningAmount() / purchaseAmount * 10000.0) / 100.0;
    }

    private double calculateWinningAmount() {
        return Arrays.stream(Rank.values())
                .mapToDouble(this::calculateRankWinningAmount)
                .sum();
    }

    private double calculateRankWinningAmount(Rank rank) {
        int count = rankStorage.get(rank);
        Long winningAmount = rank.getWinningAmount();
        return count * winningAmount;
    }
}
