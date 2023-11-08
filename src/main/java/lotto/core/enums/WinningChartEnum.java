package lotto.core.enums;

import lotto.core.exception.IllegalNullTypeException;

public enum WinningChartEnum {
    SIX_MATCH(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원)"),
    FIVE_AND_BONUS_MATCH(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIVE_MATCH(1_500_000, 5, false, "5개 일치 (1,500,000원)"),
    FOUR_MATCH(50_000, 4, false, "4개 일치 (50,000원)"),
    THREE_MATCH(5_000, 3, false, "3개 일치 (5,000원)"),
    NO_MATCH(0, 0, false, "미당첨");

    private final Integer prize;
    private final Integer matchCount;
    private final Boolean bonus;
    private final String description;

    WinningChartEnum(Integer prize, Integer matchCount, Boolean bonus, String description) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.description = description;
    }


    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPrize() {
        return prize;
    }

    public static WinningChartEnum valueOf(Integer matchCount, Boolean bonus) {
        if (matchCount < 3) {
            return NO_MATCH;
        }
        for (WinningChartEnum value : WinningChartEnum.values()) {
            if (value.matchCount.equals(matchCount) && value.bonus.equals(bonus)) {
                return value;
            }
        }
        if (matchCount != 5) {
            return valueOf(matchCount, false);
        }
        throw new IllegalNullTypeException();
    }

    public String getDescription() {
        return description;
    }
}
