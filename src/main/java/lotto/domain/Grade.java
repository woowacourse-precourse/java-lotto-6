package lotto.domain;

import java.util.Arrays;

public enum Grade {
    FIFTH("3", 3, 5_000),
    FOURTH("4", 4, 50_000),
    THIRD("5", 5, 1_500_000),
    SECOND("5+B", 5, 30_000_000),
    FIRST("6", 6, 2_000_000_000);

    private final String rank;
    private final int matchCount;
    private final int prizeMoney;
    private static final String INVALID_KEY_MESSAGE = "[ERROR] 유효하지 않은 등급 이름입니다.";

    Grade(String rank, int matchCount, int prizeMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Grade findGrade(int matchCount, int bonusCount) {
        if ((THIRD.matchCount == matchCount) && (bonusCount == 0)) {
            return THIRD;
        }
        if ((SECOND.matchCount == matchCount) && (bonusCount == 1)) {
            return SECOND;
        }
        return Arrays.stream(values()).filter(grade -> grade.matchCount == matchCount)
                .findAny().orElse(null);
    }

    public static Grade findGradeByRank(String rank) {
        return Arrays.stream(values()).filter(grade -> grade.rank.equals(rank))
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_KEY_MESSAGE));
    }

    public String getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
