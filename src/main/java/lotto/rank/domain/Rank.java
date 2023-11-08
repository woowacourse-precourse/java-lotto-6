package lotto.rank.domain;

import lotto.util.LottoConstant;

public enum Rank {
    NONE(0, 0, "꽝"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final int winningMoney;
    private final String message;

    Rank(int matchCount, int winningMoney, String message) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.message = message;
    }


    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == LottoConstant.NUMBER_SIX) {
            return FIRST;
        }
        if (matchCount == LottoConstant.NUMBER_FIVE && matchBonus) {
            return SECOND;
        }
        if (matchCount == LottoConstant.NUMBER_FIVE) {
            return THIRD;
        }
        if (matchCount == LottoConstant.NUMBER_FOUR) {
            return FOURTH;
        }
        if (matchCount == LottoConstant.NUMBER_THREE) {
            return FIFTH;
        }
        return NONE;
    }
}
