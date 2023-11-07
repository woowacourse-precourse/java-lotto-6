package lotto.domain;

import java.util.Arrays;

public class Calculator {

    ResultRepository resultRepository = new ResultRepository();

    public double getRateOfReturn() {
        return getTotalReward() / (getNumberOfLotto() *10);
    }

    private double getTotalReward() {
        return Arrays.stream(Rank.values())
                .mapToLong(value -> value.getReward() * resultRepository.findWinningByRank(value))
                .sum();
    }

    private long getNumberOfLotto() {
        return Arrays.stream(Rank.values())
                .mapToLong(value -> resultRepository.findWinningByRank(value))
                .sum();
    }
}
