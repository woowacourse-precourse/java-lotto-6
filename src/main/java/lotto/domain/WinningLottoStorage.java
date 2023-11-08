package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static lotto.utils.LottoConstants.*;

public class WinningLottoStorage {

    private final Map<Rank, Integer> rankStorage;

    public WinningLottoStorage() {
        rankStorage = new HashMap<>();
        initRankStorage();
    }

    private void initRankStorage() {
        rankStorage.put(Rank.CORRECT_ZERO, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_ONE, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_TWO, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_THREE, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_FOUR, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_FIVE, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_FIVE_BONUS, RANK_INIT_VALUE.getConstants());
        rankStorage.put(Rank.CORRECT_SIX, RANK_INIT_VALUE.getConstants());
    }

    public void store(Rank rank) {
        Integer count = rankStorage.get(rank);
        rankStorage.put(rank, count + RANK_PLUS_VALUE.getConstants());
    }

    public int getRank(Rank rank) {
        return rankStorage.get(rank);
    }

    public double getRateOfReturn(int purchaseAmount) {
        return calculateWinningAmount() / (double) purchaseAmount * RATE_OF_RETURN_MULTIPLY_VALUE.getConstants();
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
