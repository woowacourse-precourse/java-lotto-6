package lotto.domain.constant;

import java.text.NumberFormat;
import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSING(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prizeMoney;

    LottoPrize(int matchCount, boolean hasBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public static LottoPrize getLottoPrize(int matchCount, boolean isBonus) {
        long count = getSameMatchCount(matchCount);

        if (count > 1) {
            return getLottoPrizeWithoutBonus(matchCount, isBonus);
        }

        return getLottoPrizeWithoutBonus(matchCount);
    }

    private static LottoPrize getLottoPrizeWithoutBonus(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
                .findFirst()
                .orElse(LottoPrize.LOSING);
    }

    private static long getSameMatchCount(int matchCount) {
        long count = Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
                .count();

        return count;
    }

    private static LottoPrize getLottoPrizeWithoutBonus(int matchCount, boolean isBonus) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
                .filter(lottoPrize -> lottoPrize.hasBonus == isBonus)
                .findFirst()
                .orElse(LottoPrize.LOSING);
    }

    public String toMessage() {
        String prizeMoneyWithDelimiter = NumberFormat
                .getNumberInstance()
                .format(prizeMoney);

        if (!hasBonus) {
            return matchCount + "개 일치 "
                    + "(" + prizeMoneyWithDelimiter + "원)";
        }

        return matchCount + "개 일치, " + "보너스 볼 일치 "
                + "(" + prizeMoneyWithDelimiter + "원)";
    }
}
