package lotto.model;

public enum Ranking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ", false),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ", false),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ", false),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ", false),
    NO_PRIZE(0, 0, "", false);

    private final int matchCount;
    private final int prize;
    private final String description;
    private final boolean requiresBonus;

    Ranking(int matchCount, int prize, String description, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
        this.requiresBonus = requiresBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Ranking findByMatchCountAndBonus(long matchCount, boolean matchBonus) {
        for (Ranking ranking : values()) {
            if (ranking.matchCount == matchCount && (!ranking.requiresBonus || matchBonus)) {
                return ranking;
            }
        }
        return NO_PRIZE;
    }
}
