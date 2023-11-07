package lotto.constants.lotto;

import java.util.Arrays;

public enum WinningFactor {

    NONE_MATCH(0, 0, false),
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_AND_BONUS_NUMBER_MATCH(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

    private final Integer count;
    private final Integer money;
    private final Boolean isMatchBonusNumber;

    WinningFactor(Integer count, Integer money, boolean isMatchBonusNumber) {
        this.count = count;
        this.money = money;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public static WinningFactor findWinningFactorByCondition(Integer count, Boolean isMatchBonusNumber) {
        return Arrays.stream(WinningFactor.values())
                .filter(factor -> factor.count.equals(count) && factor.isMatchBonusNumber.equals(isMatchBonusNumber))
                .findFirst()
                .orElse(NONE_MATCH);
    }

    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }

    public Boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }
}
