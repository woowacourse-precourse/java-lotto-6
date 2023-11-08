package lotto.domain.grade;

import static lotto.utils.IntegerConstant.FIVE;
import static lotto.utils.IntegerConstant.FOUR;
import static lotto.utils.IntegerConstant.ONE;
import static lotto.utils.IntegerConstant.SIX;
import static lotto.utils.IntegerConstant.THREE;
import static lotto.utils.IntegerConstant.ZERO;

public enum Grade {

    FIFTH("3개 일치 (5,000원)", 5_000) {
        @Override
        public boolean filter(int numberMatchCount, int bonusMatchCount) {
            return numberMatchCount == THREE;
        }
    },
    FOURTH("4개 일치 (50,000원)", 50_000) {
        @Override
        public boolean filter(int numberMatchCount, int bonusMatchCount) {
            return numberMatchCount == FOUR;
        }
    },
    THIRD("5개 일치 (1,500,000원)", 1_500_000) {
        @Override
        public boolean filter(int numberMatchCount, int bonusMatchCount) {
            return numberMatchCount == FIVE && bonusMatchCount == ZERO;
        }
    },
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000) {
        @Override
        public boolean filter(int numberMatchCount, int bonusMatchCount) {
            return numberMatchCount == FIVE && bonusMatchCount == ONE;
        }
    },
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000) {
        @Override
        public boolean filter(int numberMatchCount, int bonusMatchCount) {
            return numberMatchCount == SIX;
        }
    },
    NONE("꽝", 0) {
        @Override
        public boolean filter(int numberMatchCount, int bonusMatchCount) {
            return true;
        }
    };

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

    public abstract boolean filter(int numberMatchCount, int bonusMatchCount);


    public static Grade of(int numberMatchCount, int bonusMatchCount) {
        for (Grade grade : Grade.values()) {
            if (grade.filter(numberMatchCount, bonusMatchCount)) {
                return grade;
            }
        }
        return NONE;
    }
}
