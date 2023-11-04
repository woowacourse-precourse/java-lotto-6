package lotto.enums;

import lotto.exception.IllegalNullTypeException;

public enum WinningChartEnum {
    SIX_MATCH(2_000_000_000, 6, false),
    FIVE_AND_BONUS_MATCH(30_000_000, 5, true),
    FIVE_MATCH(1_500_000, 5, false),
    FOUR_MATCH(50_000, 4, false),
    THREE_MATCH(5_000, 3, false);

    private final Integer prize;
    private final Integer matchCount;
    private final Boolean bonus;

    WinningChartEnum(Integer prize, Integer matchCount, Boolean bonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }


    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPrize() {
        return prize;
    }

    public static WinningChartEnum valueOf(Integer matchCount, Boolean bonus) {
        for (WinningChartEnum value : WinningChartEnum.values()) {
            if (value.matchCount.equals(matchCount) && value.bonus.equals(bonus)) {
                return value;
            }
        }
        if (matchCount != 5 && bonus) {
            return valueOf(matchCount, false);
        }

        throw new IllegalNullTypeException();
    }
}
