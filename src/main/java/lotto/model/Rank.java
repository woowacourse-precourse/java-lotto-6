package lotto.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {
    NO_RANK(0, 0L, false),
    FIFTH(3, 5_000L, false),
    FOURTH(4, 50_000L, false),
    THIRD(5, 1_500_000L, false),
    SECOND(5, 30_000_000L, true),
    FIRST(6, 2_000_000_000L, false);

    private int matchCount;
    private long prizeMoney;
    private boolean isBonus;

    Rank(int matchCount, long prizeMoney, boolean isBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonus = isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean isBonus) {
        if (isBonus && matchCount == Rank.THIRD.matchCount) {
            return Rank.SECOND;
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
        if (isBonus) {
            message.append(", 보너스 볼 일치");
        }
        message.append(" (").append(decFormat.format(prizeMoney)).append("원) - ");
        return message.toString();
    }
}
