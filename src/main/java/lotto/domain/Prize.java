package lotto.domain;

import java.util.Arrays;

public enum Prize {
    ZERO(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false,1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false,2000000000);




    private final int equalNumCount;
    private final boolean hasCheckBonus;
    private final int winningAmount;

    Prize(int equalNumCount, boolean hasCheckBonus, int winningAmount) {
        this.equalNumCount = equalNumCount;
        this.hasCheckBonus = hasCheckBonus;
        this.winningAmount = winningAmount;
    }

    public int getEqualNumCount() {
        return equalNumCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static Prize rankLotto(int matchingCount, boolean isBonusMatching) {
        if (matchingCount == 5 && isBonusMatching) {
            return SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.equalNumCount == matchingCount)
                .findAny()
                .orElse(ZERO);

    }

    public String convertWinningAmount() {
        return Integer.toString(winningAmount).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");

    }

}
