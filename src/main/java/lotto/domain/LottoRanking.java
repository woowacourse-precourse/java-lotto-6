package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {

    FIRST(6f, 2000000000),
    SECOND(5.5f, 30000000),
    THIRD(5f, 1500000),
    FOURTH(4f, 50000),
    FIFTH(3f, 5000);

    private final Float score;
    private final Integer prizeMoney;

    LottoRanking(Float score, Integer prizeMoney) {
        this.score = score;
        this.prizeMoney = prizeMoney;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRanking valueOfScore(Float score) {
        return Arrays.stream(values())
                .filter(value -> value.score.equals(score))
                .findAny()
                .orElse(null);
    }
}
