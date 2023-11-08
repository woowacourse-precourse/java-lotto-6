package lotto.domain;

public enum LottoPrize {
    NOTHING_PRIZE(2, 0, false),
    FIFTH_PRIZE(3, 5_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    THIRD_PRIZE(5, 1_500_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    FIRST_PRIZE(6, 2_000_000_000, false);

    private final int matchNumbers;
    private final int prizeMoney;
    private final boolean isBonusNumber;

    LottoPrize(int matchNumbers, int prizeMoney, boolean isBonusNumber) {
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
        this.isBonusNumber = isBonusNumber;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public static LottoPrize getPrizeRank(int matchNumbers, boolean isMatchBonus) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (isMatch(lottoPrize, matchNumbers, isMatchBonus)) {
                return lottoPrize;
            }
        }
        return LottoPrize.NOTHING_PRIZE;
    }

    private static boolean isMatch(LottoPrize lottoPrize, int matchNumbers, boolean isMatchBonus) {
        return lottoPrize.getMatchNumbers() == matchNumbers && lottoPrize.isBonusNumber == isMatchBonus;
    }

    public String getResultMessage(int count) {
        if (isSecondPrizeResult()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumbers, prizeMoney, count);
        }
        return String.format("%d개 일치 (%,d원) - %d개", matchNumbers, prizeMoney, count);
    }

    private boolean isSecondPrizeResult() {
        return matchNumbers == SECOND_PRIZE.getMatchNumbers() && prizeMoney == SECOND_PRIZE.getPrizeMoney()
                && isBonusNumber == SECOND_PRIZE.isBonusNumber();
    }
}
