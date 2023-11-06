package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NO_RANK(0, 0, "꽝");

    private final int matchCount;
    private final int prize;
    private final String message;

    Rank(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static Rank findByMatchCountAndBonus(int matchCount, boolean matchBonus) {
        if (matchCount < FIFTH.matchCount) {
            return NO_RANK;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == THIRD.matchCount && !matchBonus) {
            return THIRD;
        }
        if (matchCount == SECOND.matchCount) {
            return SECOND;
        }
        return FIRST;
    }

    public static Map<Rank, Integer> createNewSheet() {
        return new HashMap<>(Map.of(
                FIRST, 0,
                SECOND, 0,
                THIRD, 0,
                FOURTH, 0,
                FIFTH, 0,
                NO_RANK, 0
        ));
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
