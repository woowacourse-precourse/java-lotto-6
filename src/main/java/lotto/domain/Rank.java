package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST_RANK(6, 2000000000)
    , SECOND_RANK(7, 30000000)
    , THIRD_RANK(5, 1500000)
    , FOURTH_RANK(4, 50000)
    , FIFTH_RANK(3, 5000)
    , NO_RANK(2, 0);

    private final int RANK;
    private final int MONEY;

    Rank(int rank, int money) {
        RANK = rank;
        MONEY = money;
    }

    public static int prize(int rank) {
        List<Rank> ranks = List.of(Rank.values());
        Rank winPrize = ranks.stream().filter(prize -> prize.RANK == rank).findFirst().orElse(NO_RANK);
        return winPrize.MONEY;
    }
}
