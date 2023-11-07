package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningLottoStorage {

    private static final int RANK_INIT_VALUE = 0;
    private static final int RANK_PLUS_VALUE = 1;
    private static final int RATE_OF_RETURN_MULTIPLY_VALUE = 100;
    private final Map<Rank, Integer> rankStorage;

    public WinningLottoStorage() {
        rankStorage = new HashMap<>();
        initRankStorage();
    }

    private void initRankStorage() {
        rankStorage.put(Rank.CORRECT_ZERO, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_ONE, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_TWO, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_THREE, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_FOUR, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_FIVE, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_FIVE_BONUS, RANK_INIT_VALUE);
        rankStorage.put(Rank.CORRECT_SIX, RANK_INIT_VALUE);
    }

    public void store(Rank rank) {
        Integer count = rankStorage.get(rank);
        rankStorage.put(rank, count + RANK_PLUS_VALUE);
    }

    public int getRank(Rank rank) {
        return rankStorage.get(rank);
    }

    public double getRateOfReturn(int purchaseAmount) {
        return calculateWinningAmount() / (double)purchaseAmount * RATE_OF_RETURN_MULTIPLY_VALUE;
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
