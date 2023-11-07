package lotto.model;

import lotto.util.Validator;

public enum Prize {
    SIX_MATCH("6개 일치 (2,000,000,000원)", 2000000000),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIVE_MATCH("5개 일치 (1,500,000원)", 1500000),
    FOUR_MATCH("4개 일치 (50,000원)", 50000),
    THREE_MATCH("3개 일치 (5,000원)", 5000);


    private final String message;
    private final int prizeMoney;

    Prize(String message, int prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(int matchCount, boolean matchBonusNumber) {
        Validator.validateMatchCount(matchCount);
        if (matchCount == 6) {
            return SIX_MATCH;
        }
        if (matchCount == 5 && matchBonusNumber) {
            return FIVE_MATCH_WITH_BONUS;
        }
        if (matchCount == 5) {
            return FIVE_MATCH;
        }
        if (matchCount == 4) {
            return FOUR_MATCH;
        }
        return THREE_MATCH;
    }

    public String getMessage() {
        return message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
