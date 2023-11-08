package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum Rank {

    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ", false),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", true),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - ", false),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - ", false),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ", false),
    NONE(0, 0, "0", false);

    private final int matchCount;
    private final long prize;
    private final String prizeMessage;
    private final boolean isBonus;

    Rank(int matchCount, long prize, String prizeMessage, boolean isBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeMessage = prizeMessage;
        this.isBonus = isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return isBonus;
    }
}