package lotto.domain;

import lotto.constants.Value;

public enum Rank {
    NO_RANK_ZERO(0, 0),
    NO_RANK_ONE(0, 0),
    NO_RANK_TWO(0, 0),
    FIFTH(3, Value.LOTTO_5_RANK_PRIZE_MONEY),
    FOURTH(4, Value.LOTTO_4_RANK_PRIZE_MONEY),
    THIRD(5, Value.LOTTO_3_RANK_PRIZE_MONEY),
    FIRST(6, Value.LOTTO_1_RANK_PRIZE_MONEY),
    SECOND(5, Value.LOTTO_2_RANK_PRIZE_MONEY);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

}
