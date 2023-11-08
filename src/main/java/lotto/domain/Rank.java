package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000L, false), // 1등
    SECOND(5, 30_000_000L, true), // 2등
    THIRD(5, 1_500_000L, false), // 3등
    FOURTH(4, 50_000L, false), // 4등
    FIFTH(3, 5_000L, false), // 5등
    NOTHING(0, 0L, false);

    private final int matchCount;
    private final long prizeMoney;
    private final boolean matchBonus;

    Rank(int matchCount, long prizeMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney= prizeMoney;
        this.matchBonus = matchBonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (THIRD.matchCount == matchCount && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public String getMessage() {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        StringBuilder message = new StringBuilder();
        message.append(matchCount).append("개 일치");
        if (matchBonus) {
            message.append(", 보너스 볼 일치");
        }
        message.append(" (").append(decFormat.format(prizeMoney)).append("원) - ");
        return message.toString();
    }
}
