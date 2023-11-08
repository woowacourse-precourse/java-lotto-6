package lotto.module.rank.impl;

import lotto.module.rank.Rank;

public class FourthPlace implements Rank {
    private static final FourthPlace fourthPlace = new FourthPlace();
    private static final int PRIZE = 50_000;
    private static final int MATCH_COUNT = 4;

    private FourthPlace() {
    }

    public static FourthPlace getSingleton() {
        return fourthPlace;
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
