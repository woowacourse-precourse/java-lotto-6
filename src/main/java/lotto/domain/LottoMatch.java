package lotto.domain;

import lotto.util.Constants;

public enum LottoMatch {
    MISS(0,0,""),
    FIFTH(3, 5_000, Constants.END_RESULT_MESSAGE_3),
    FOURTH(4, 5_000, Constants.END_RESULT_MESSAGE_4),
    THIRD(5, 5_000, Constants.END_RESULT_MESSAGE_5),
    SECOND(5, 5_000, Constants.END_RESULT_MESSAGE_6),
    FIRST(6, 5_000, Constants.END_RESULT_MESSAGE_BONUS);
    private int matchCount;
    private int lottoPrize;
    private String resultMessage;
    LottoMatch(int matchCount, int lottoPrize, String resultMessage) {
        this.matchCount = matchCount;
        this.lottoPrize = lottoPrize;
        this.resultMessage = resultMessage;
    }

}
