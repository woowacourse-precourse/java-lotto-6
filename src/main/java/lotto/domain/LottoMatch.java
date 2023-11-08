package lotto.domain;

import lotto.util.Constants;

public enum LottoMatch {
    MISS(0, 0, ""),
    THIRD(3, 5000, Constants.END_RESULT_MESSAGE_3 ),
    FOURTH(4, 50000, Constants.END_RESULT_MESSAGE_4 ),
    FIFTH(5, 1500000, Constants.END_RESULT_MESSAGE_5),
    SECOND(5, 30000000, Constants.END_RESULT_MESSAGE_BONUS ),
    FIRST(6, 2000000000, Constants.END_RESULT_MESSAGE_6);

    private final int matchCount;
    private final int prizeMoney;
    private final String resultMessage;

    LottoMatch(int matchCount, int prizeMoney, String resultMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.resultMessage = resultMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public static LottoMatch findByMatchCount(int matchCount, boolean isBonusMatch) {
        if (isBonusMatch) {
            return SECOND;
        }
        for (LottoMatch match : values()) {
            if (match.matchCount == matchCount) {
                return match;
            }
        }
        return MISS;
    }
}
