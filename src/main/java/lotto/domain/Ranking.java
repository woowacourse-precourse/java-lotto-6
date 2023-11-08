package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIFTH(3, false, "3개 일치 (5,000원)", 5_000),
    FOURTH(4, false, "4개 일치 (50,000원)", 50_000),
    THIRD(5, false, "5개 일치 (1,500,000원)", 1_500_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final String comment;
    private final int prize;

    Ranking(int matchCount, boolean matchBonus, String comment, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.comment = comment;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getComment() {
        return comment;
    }

    public static Ranking of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchCount == matchCount)
                .filter(ranking -> ranking.matchBonus == matchBonus)
                .findFirst()
                .orElse(null);
    }
}
