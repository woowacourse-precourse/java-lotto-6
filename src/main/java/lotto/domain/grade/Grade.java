package lotto.domain.grade;

import lotto.utils.IntegerConstant;

public enum Grade {

    FIFTH("3개 일치 (5,000원)", 5_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000),
    NONE("꽝", 0);

    private final String description;
    private final int winningMoney;

    public String getDescription() {
        return description;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    Grade(String description, int winningMoney) {
        this.description = description;
        this.winningMoney = winningMoney;
    }

    public static Grade of(int numberMatchCount, int bonusMatchCount) {
        if (numberMatchCount == IntegerConstant.SIX) {
            return FIRST;
        }
        if (numberMatchCount == IntegerConstant.FIVE && bonusMatchCount == IntegerConstant.ONE) {
            return SECOND;
        }
        if (numberMatchCount == IntegerConstant.FIVE) {
            return THIRD;
        }
        if (numberMatchCount == IntegerConstant.FOUR) {
            return FOURTH;
        }
        if (numberMatchCount == IntegerConstant.THREE) {
            return FIFTH;
        }

        return NONE;
    }
}
