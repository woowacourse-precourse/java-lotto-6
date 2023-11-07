package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(1, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(5, 5000, "3개 일치 (5,000원)"),
    NONE(0, 0, "")
    ;

    private final Integer rank;
    private final Integer reward;
    private final String message;

    Ranking(Integer rank, Integer reward, String message) {
        this.rank = rank;
        this.reward = reward;
        this.message = message;
    }

    public Integer rank() {
        return rank;
    }

    public Integer reward() {
        return reward;
    }

    public String message() {
        return message;
    }

    public static Ranking findRankingByRank(Integer rank) {
        return Arrays.stream(values())
                .filter(value -> value.rank.equals(rank))
                .findAny()
                .orElse(null);
    }
}
