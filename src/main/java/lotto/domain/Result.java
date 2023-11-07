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
}
