package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoResult {
    LOSE(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int hitNumberCount;
    private final int prizeMoney;
    private final boolean hasBonus;

    LottoResult(int hitNumberCount, int prizeMoney, boolean hasBonus) {
        this.hitNumberCount = hitNumberCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = hasBonus;
    }

    public int getHitNumberCount() {
        return hitNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    public boolean isLose() {
        return this.equals(LOSE);
    }

    public static LottoResult of(int hitNumberCount, boolean hasBonus) {
        return Arrays.stream(LottoResult.values())
                .filter(gameResult -> gameResult.isEqualHitNumberCount(hitNumberCount))
                .filter(gameResult -> gameResult.hasBonus(hasBonus))
                .findFirst()
                .orElse(LOSE);
    }

    private boolean isEqualHitNumberCount(int hitNumberCount) {
        return this.hitNumberCount == hitNumberCount;
    }

    private boolean hasBonus(boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

}
