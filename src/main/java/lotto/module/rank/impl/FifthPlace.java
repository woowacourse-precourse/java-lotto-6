package lotto.module.rank.impl;

import lotto.module.rank.Rank;

public class FifthPlace implements Rank {
    private static final FifthPlace fifthPlace = new FifthPlace();
    private static final int RANK = 5;
    private static final int PRIZE = 5_000;
    private static final int MATCH_COUNT = 3;

    private FifthPlace() {
    }

    public static FifthPlace getSingleton() {
        return fifthPlace;
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
