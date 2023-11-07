package lotto.domain;

import static lotto.util.NumberConstant.*;

public enum Rank {
    FIFTH(FIFTH_WINNINGS_MONEY, FIFTH_NUMBER_NUM),
    FOURTH(FOURTH_WINNINGS_MONEY, FOURTH_NUMBER_NUM),
    THIRD(THIRD_WINNINGS_MONEY, THIRD_NUMBER_NUM),
    SECOND(SECOND_WINNINGS_MONEY, SECOND_NUMBER_NUM),
    FIRST(FIRST_WINNINGS_MONEY, FIRST_NUMBER_NUM),
    LOSE(LOSE_LOTTO, LOSE_NUMBER_NUM);

    private final Double PRIZE_MONEY;
    private final Integer WINNING_NUM;

    Rank(Double prizeMoney, Integer winningNum) {
        this.PRIZE_MONEY = prizeMoney;
        this.WINNING_NUM = winningNum;
    }

    public static Rank resultRank(Integer num) {
        for (Rank rank : Rank.values()) {
            if (rank.WINNING_NUM.equals(num)) {
                return rank;
            }
        }
        return Rank.LOSE;
    }

    public Double getPrizeMoney() {
        return PRIZE_MONEY;
    }
}
