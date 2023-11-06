package lotto.domain;

import java.util.Arrays;

public enum LotteryRanking {
    FIRST(2000000000) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            return counts == 6;
        }
    }, SECOND(30000000) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            if (isBonusNumberMatch) {
                return counts == 5;
            }
            return false;
        }
    }, THIRD(1500000) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            if (isBonusNumberMatch) {
                return counts == 4;
            }
            return counts == 5;
        }
    }, FORTH(50000) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            if (isBonusNumberMatch) {
                return counts == 3;
            }
            return counts == 4;
        }
    }, FIFTH(5000) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            if (isBonusNumberMatch) {
                return counts == 2;
            }
            return counts == 3;
        }
    }, LAST_PLACE(0) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            if (isBonusNumberMatch) {
                return counts < 2;
            }
            return counts < 3;
        }
    };

    private int amount;

    LotteryRanking(int amount) {
        this.amount = amount;
    }

    public static LotteryRanking getRanking(int counts, boolean isBonusNumberMatch) {
        return Arrays.stream(LotteryRanking.values())
                .filter(ranking -> ranking.matches(counts, isBonusNumberMatch))
                .findFirst().get();
    }

    public abstract boolean matches(int counts, boolean isBonusNumberMatch);

    public int getAmount() {
        return this.amount;
    }

}
