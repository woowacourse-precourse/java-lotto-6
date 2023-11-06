package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NOTHING(0, 0, false);

    private final int matchCount;
    private final long prize;
    private final boolean matchBonus;

    Rank(int matchCount, long prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches(matchCount, matchBonus))
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    public boolean matches(int count, boolean hasBonus) {
        return this.matchCount == count && this.matchBonus == hasBonus;
    }

    public long getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        String prizeFormat = String.format("%,d원", prize);
        if(this.equals(SECOND)){
            return String.format("%d개 일치, 보너스 볼 일치 (%s)",matchCount, prizeFormat);
        }
        return String.format("%d개 일치 (%s)", matchCount, prizeFormat);
    }
}