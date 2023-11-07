package lotto.domain;

import lotto.configure.DomainConfiguration;

import java.util.Arrays;

public class Result {
    private final Integer[] countsOfEachRank;

    public Result() {
        this.countsOfEachRank = new Integer[DomainConfiguration.RANGE_OF_RANK];
        Arrays.fill(this.countsOfEachRank, 0);
    }

    public void addCount(int rank) {
        this.countsOfEachRank[rank - 1]++;
    }

    public int getCount(int rank) {
        return this.countsOfEachRank[rank - 1];
    }

    public double calculateRateOfReturn(int purchasePrice) {
        return (double)RateOfReturnCalculator.calculate(calculateTotalReward(), purchasePrice);
    }

    private int calculateTotalReward() {
        int sum = 0;
        for (int i = 0; i < this.countsOfEachRank.length; i++) {
            sum += DomainConfiguration.REWARD_PER_RANK.get(i + 1) * this.countsOfEachRank[i];
        }
        return sum;
    }
}
