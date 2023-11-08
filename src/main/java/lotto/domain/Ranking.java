package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, true, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, false, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int count;
    private final boolean hasBonus;
    private final int prize;
    private final String message;

    private Ranking(int count, boolean hasBonus, int prize, String message) {
        this.count = count;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Ranking rank(int count, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(ranking -> isEqualToRanking(ranking, count, hasBonus))
                .findFirst()
                .orElse(null);
    }

    private static Boolean isEqualToRanking(Ranking ranking, int count, boolean hasBonus) {
        return ranking.getCount() == count && ranking.hasBonus == hasBonus;
    }

    public int getCount() {
        return count;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
