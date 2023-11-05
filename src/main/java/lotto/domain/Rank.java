package lotto.domain;

import java.math.BigDecimal;

public enum Rank {
    FIRST(6, false, new BigDecimal(2_000_000_000L)),
    SECOND(5, true, new BigDecimal(30_000_000L)),
    THIRD(5, false, new BigDecimal(1_500_000L)),
    FOURTH(4, false, new BigDecimal(50_000L)),
    FIFTH(3, false, new BigDecimal(5_000L)),
    NONE(0, false, new BigDecimal(0L));

    private final int matchCounts;
    private final boolean matchBonus;
    private final BigDecimal price;

    Rank(int matchCounts, boolean matchBonus, BigDecimal price) {
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Rank calculateRank(final int matchCounts, final boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCounts == matchCounts && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchCounts() {
        return matchCounts;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
