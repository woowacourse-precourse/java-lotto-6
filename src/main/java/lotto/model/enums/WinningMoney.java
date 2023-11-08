package lotto.model.enums;

import java.util.Arrays;

public enum WinningMoney {
    NON_MATCH(0, false, 0),
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);

    private int matchCount;
    private boolean hasBonus;
    private long price;

    WinningMoney(int matchCount, boolean hasBonus, long price) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.price = price;
    }

    public static WinningMoney from(int matchCount, boolean hasBonus) {
        return Arrays.stream(WinningMoney.values())
                .filter(count -> count.matchCount == matchCount)
                .filter(bonus -> bonus.hasBonus == hasBonus)
                .findAny()
                .orElse(NON_MATCH);
    }

    public static long calculateMoney(WinningMoney winningMoney, int count) {
        return WinningMoney.valueOf(winningMoney.name()).getPrice() * count;
    }

    private long getPrice() {
        return price;
    }
}
