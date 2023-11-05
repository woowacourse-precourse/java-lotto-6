package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);
    private final int sameNumber;

    private final int winningPrice;

    private final boolean hasBonus;
    LottoResult(int sameNumber, int winningPrice, boolean isBonus) {
        this.sameNumber = sameNumber;
        this.winningPrice = winningPrice;
        this.hasBonus = isBonus;
    }

    public static LottoResult getResult(int sameNumberCount, boolean hasBonus) {
        return Arrays.stream(LottoResult.values())
                .filter(gameResult -> gameResult.isEqualSameNumber(sameNumberCount))
                .filter(gameResult -> gameResult.isEqualHasBonus(hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isEqualHasBonus(boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

    private boolean isEqualSameNumber(int sameNumber){
        return this.sameNumber == sameNumber;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }
}
