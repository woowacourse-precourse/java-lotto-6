package lotto;

import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST((lotto, winning) -> countMatches(lotto, winning) == Constants.FIRST_COUNT,
            new Money(Constants.FIRST_PRIZE_VALUE)),
    SECOND((lotto, winning) -> countMatches(lotto, winning) == Constants.SECOND_COUNT && hasBonusNumber(lotto, winning),
            new Money(Constants.SECOND_PRIZE_VALUE)),
    THIRD((lotto, winning) -> countMatches(lotto, winning) == Constants.THIRD_COUNT,
            new Money(Constants.THIRD_PRIZE_VALUE)),
    FOURTH((lotto, winning) -> countMatches(lotto, winning) == Constants.FOURTH_COUNT,
            new Money(Constants.FOURTH_PRIZE_VALUE)),
    FIFTH((lotto, winning) -> countMatches(lotto, winning) == Constants.FIFTH_COUNT,
            new Money(Constants.FIFTH_PRIZE_VALUE)),
    NONE((lotto, winning) -> true,
            new Money(Constants.NONE_PRIZE_VALUE));

    private final BiPredicate<Lotto, WinningLotto> judge;
    private final Money prize;

    public Money getPrize() {
        return prize;
    }

    LottoRank(BiPredicate<Lotto, WinningLotto> judge, Money prize) {
        this.judge = judge;
        this.prize = prize;
    }

    private static long countMatches(Lotto lotto, WinningLotto winning) {
        return lotto.getNumbers().stream()
                .filter(winning.getNumbers()::contains)
                .count();
    }

    private static boolean hasBonusNumber(Lotto lotto, WinningLotto winning) {
        return lotto.getNumbers().contains(winning.getBonusNumber());
    }

    public static LottoRank judge(Lotto lotto, WinningLotto winningLotto) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.judge.test(lotto, winningLotto)) {
                return rank;
            }
        }
        return NONE;
    }

    private static class Constants {
        public static final int FIRST_PRIZE_VALUE = 2000000000;
        public static final int SECOND_PRIZE_VALUE = 30000000;
        public static final int THIRD_PRIZE_VALUE = 1500000;
        public static final int FOURTH_PRIZE_VALUE = 50000;
        public static final int FIFTH_PRIZE_VALUE = 5000;
        public static final int FIRST_COUNT = 6;
        public static final int SECOND_COUNT = 5;
        public static final int THIRD_COUNT = 5;
        public static final int FOURTH_COUNT = 4;
        public static final int FIFTH_COUNT = 3;
        public static final int NONE_PRIZE_VALUE = 0;
    }
}
