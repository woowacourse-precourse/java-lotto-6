package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5,true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    OUT_OF_RANKS(0, false, 0);

    private static final String MATCH_COUNT_DESCRIPTION = "%d개 일치";
    private static final String BONUS_DESCRIPTION = ", 보너스 볼 일치";
    private static final String PRIZE_DESCRIPTION = " (%,d원)";
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append(String.format(MATCH_COUNT_DESCRIPTION, matchCount));
        if (matchBonus) {
            descriptionBuilder.append(BONUS_DESCRIPTION);
        }
        descriptionBuilder.append(String.format(PRIZE_DESCRIPTION, prize));
        return descriptionBuilder.toString();
    }
}
