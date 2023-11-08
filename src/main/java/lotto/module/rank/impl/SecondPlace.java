package lotto.module.rank.impl;

import lotto.module.rank.Rank;

public class SecondPlace implements Rank {
    private static final SecondPlace secondPlace = new SecondPlace();
    private static final int RANK = 2;
    private static final int PRIZE = 30_000_000;
    private static final int MATCH_COUNT = 5;

    private SecondPlace() {
    }

    public static SecondPlace getSingleton() {
        return secondPlace;
    }

    @Override
    public int getPrize() {
        return PRIZE;
    }

    @Override
    public int getMatchCount() {
        return MATCH_COUNT;
    }

    @Override
    public int getRank() {
        return RANK;
    }

}
