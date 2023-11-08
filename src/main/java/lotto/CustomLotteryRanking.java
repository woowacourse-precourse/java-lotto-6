package lotto;

import java.util.Arrays;
import lotto.domain.LotteryRanking;

public enum CustomLotteryRanking implements LotteryRanking {
    LAST_PLACE(0, 2) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            int matches = getMatches();
            if (isBonusNumberMatch) {
                return counts <= matches - 1;
            }
            return counts <= matches;
        }
    },
    FIFTH(5000, 3) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            int matches = getMatches();
            if (isBonusNumberMatch) {
                return counts == matches - 1;
            }
            return counts == matches;
        }
    },
    FORTH(50000, 4) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            int matches = getMatches();
            if (isBonusNumberMatch) {
                return counts == matches - 1;
            }
            return counts == matches;
        }
    },
    THIRD(1500000, 5) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            int matches = getMatches();
            if (isBonusNumberMatch) {
                return counts == matches - 1;
            }
            return counts == matches;
        }
    },
    SECOND(30000000, 5) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            int matches = getMatches();
            if (isBonusNumberMatch) {
                return counts == matches;
            }
            return false;
        }
    },
    FIRST(2000000000, 6) {
        @Override
        public boolean matches(int counts, boolean isBonusNumberMatch) {
            int matches = getMatches();
            return counts == matches;
        }
    };

    private int amount;
    private int matches;

    CustomLotteryRanking(int amount, int matches) {
        this.amount = amount;
        this.matches = matches;
    }

    public static CustomLotteryRanking getRanking(int counts, boolean isBonusNumberMatch) {
        return Arrays.stream(CustomLotteryRanking.values())
                .filter(ranking -> ranking.matches(counts, isBonusNumberMatch))
                .findFirst().get();
    }

    public abstract boolean matches(int counts, boolean isBonusNumberMatch);

    public int getAmount() {
        return this.amount;
    }

    public String getName() {
        return this.name();
    }

    public int getMatches() {
        return this.matches;
    }
}
