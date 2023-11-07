package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottosResult {

    public int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            totalPrize += calculateOncePrize(entry);
        }
        return totalPrize;
    }

    private int calculateOncePrize(Map.Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int count = entry.getValue();
        int prize = rank.getPrizeMoney();
        return count * prize;
    }

    public List<Integer> countEachRank(Map<Rank, Integer> results) {
        List<Integer> eachRankNumber = Arrays.stream(Rank.values())
                .filter(rank -> !isZero(rank))
                .map(rank -> results.getOrDefault(rank, 0))
                .collect(Collectors.toList());
        return eachRankNumber;
    }

    private boolean isZero(Rank rank) {
        return rank == Rank.ZERO;
    }
}
