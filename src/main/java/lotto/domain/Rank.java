package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int countOfMatch;
    private final int prize;
    private final boolean matchBonus;

    Rank(int countOfMatch, int prize, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus)
                .findAny()
                .orElse(MISS);
    }

    public int getPrize() {
        return prize;
    }


}
