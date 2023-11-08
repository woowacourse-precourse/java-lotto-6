package lotto.module.rank.impl;

import lotto.module.rank.Rank;

public class FirstPlace implements Rank {
    private static final FirstPlace firstPlace = new FirstPlace();
    private static final int PRIZE = 2_000_000_000;
    private static final int MATCH_COUNT = 6;

    private FirstPlace() {
    }

    public static FirstPlace getSingleton() {
        return firstPlace;
    }

    @Override
    public int getPrize() {
        return PRIZE;
    }

    @Override
    public int getMatchCount() {
        return MATCH_COUNT;
    }

}
