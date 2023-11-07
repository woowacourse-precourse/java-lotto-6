package lotto.domain;

import java.text.DecimalFormat;

public enum Rank {
    FIRST(2000000000L, 6, 0),
    SECOND(30000000L, 5, 1),
    THIRD(1500000L, 5, 0),
    FOURTH(50000L, 4, 0),
    FIFTH(5000L, 3, 0),
    OTHER(0L, 0, 0);

    private final Long prize;
    private final Integer matchWinning;
    private final Integer matchBonus;
    private final DecimalFormat df = new DecimalFormat("###,###");

    Rank(Long prize, Integer matchWinning, Integer matchBonus) {
        this.prize = prize;
        this.matchWinning = matchWinning;
        this.matchBonus = matchBonus;
    }

    public Long getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        return df.format(prize);
    }

    public Integer getMatchWinning() {
        return matchWinning;
    }

    public Integer getMatchBonus() {
        return matchBonus;
    }
}
