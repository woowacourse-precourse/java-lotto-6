package lotto.domain.enums;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000, Message.FIRST),
    SECOND(5, 30000000, Message.SECOND),
    THIRD(5, 1500000, Message.THIRD),
    FOURTH(4, 50000, Message.FOURTH),
    FIFTH(3, 5000, Message.FIFTH),
    NONE(0, 0, null);

    private final int matchCount;
    private final int prizeMoney;
    private final Message message;

    Prize(int matchCount, int prizeMoney, Message message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }
    public int getPrizeMoney() {
        return prizeMoney;
    }

    public Message getMessage() {
        return message;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(prize -> matchCount == prize.matchCount)
                .findFirst()
                .orElse(NONE);
    }
}
