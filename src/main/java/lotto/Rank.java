package lotto;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NORANK(0, 0);

    private static final Map<Integer, String> RANK_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Rank::getCorrectNumberCnt, Rank::name)));

    private final int correctNumberCnt;
    private final int rewardMoney;

    Rank(int correctNumberCnt, int rewardMoney) {
        this.correctNumberCnt = correctNumberCnt;
        this.rewardMoney = rewardMoney;
    }

    public int getCorrectNumberCnt() {
        return correctNumberCnt;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static Rank findRank(int matchNumberCnt, boolean isBonus) {
        if (SECOND.correctNumberCnt == matchNumberCnt && isBonus) {
            return SECOND;
        }
        return Rank.valueOf(RANK_MAP.get(matchNumberCnt));
    }

}
