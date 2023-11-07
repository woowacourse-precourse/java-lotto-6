package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Reward {
    MATCH_ZERO(0,0),
    MATCH_ONE(0,0),
    MATCH_TWO(0,0),
    MATCH_THREE(3, 5000L),
    MATCH_FOUR(4, 50000L),
    MATCH_FIVE_NOT_BONUS(5, 1500000L),
    MATCH_SIX(6, 2000000000L),
    MATCH_FIVE_BONUS(5, 30000000L);
    private final int count;
    private final long prize;

    Reward(int count, long prize) {

        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

//    public static Reward getReward(int matchCount) {
//        return Arrays.stream(values())
//                .filter(reward -> reward.count == matchCount)
//                .findFirst()
//                .orElseThrow(new IllegalArgumentException());
//
//    }
}

