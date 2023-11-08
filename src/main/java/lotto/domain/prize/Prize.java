package lotto.domain.prize;

import java.util.Arrays;

public enum Prize {
    NOTHING("꽝", 0, 0, false),
    FIFTH("3개 일치 (5,000원)", 5_000, 3, false),
    FOURTH("4개 일치 (50,000원)", 50_000, 4, false),
    THIRD("5개 일치 (1,500,000원)", 1_500_000, 5, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 5, true),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000, 6, false),
    ;

    private final String message;
    private final int winningAmount;
    private final int matchCount;
    private final boolean needBonus;

    Prize(String message, int winningAmount, int matchCount, boolean needBonus) {
        this.message = message;
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
        this.needBonus = needBonus;
    }

    public String getMessage() {
        return message;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean isNothing() {
        return this == Prize.NOTHING;
    }

    public static Prize of(int matchCount, boolean hasBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> !prize.needBonus || hasBonus)
                .findAny()
                .orElse(Prize.NOTHING);
    }
}
