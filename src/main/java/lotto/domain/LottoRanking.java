package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIFTH(3f, 5000, "3개 일치 (5,000원)"),
    FOURTH(4f, 50000, "4개 일치 (50,000원)"),
    THIRD(5f, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5.5f, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6f, 2000000000, "6개 일치 (2,000,000,000원)");

    private final Float score;
    private final Integer prizeMoney;
    private final String condition;
    private int count = 0;

    LottoRanking(Float score, Integer prizeMoney, String condition) {
        this.score = score;
        this.prizeMoney = prizeMoney;
        this.condition = condition;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public String getCondition() {
        return condition;
    }

    public int getCount() {
        return count;
    }

    public String getResult() {
        return condition + " - " + count + "개";
    }

    public static LottoRanking valueOfScore(Float score) {
        return Arrays.stream(values())
                .filter(value -> value.score.equals(score))
                .findAny()
                .orElse(null);
    }

    public void plusCount() {
        this.count++;
    }
}
