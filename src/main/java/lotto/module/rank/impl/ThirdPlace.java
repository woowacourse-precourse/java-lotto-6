package lotto.module.rank.impl;

import lotto.module.rank.Rank;

public class ThirdPlace implements Rank {
    private static final ThirdPlace thirdPlace = new ThirdPlace();
    private static final int RANK = 3;
    private static final int PRIZE = 1_500_000;
    private static final int MATCH_COUNT = 5;

    private ThirdPlace() {
    }

    public static ThirdPlace getSingleton() {
        return thirdPlace;
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
