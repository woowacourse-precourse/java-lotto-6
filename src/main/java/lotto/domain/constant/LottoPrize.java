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

    private static final String MATCH_MESSAGE = "개 일치" ;
    private static final String MATCH_BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String PREFIX_BRACKET = " (";
    private static final String POST_BRACKET = "원)";
    private final int matchCount;
    private final boolean hasBonus;
    private final int prizeMoney;

    LottoPrize(int matchCount, boolean hasBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize getLottoPrize(int matchCount, boolean isBonus) {
        long count = getSameMatchCount(matchCount);

        if (count > 1) {
            return getLottoPrizeWithBonus(matchCount, isBonus);
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

    private static LottoPrize getLottoPrizeWithBonus(int matchCount, boolean isBonus) {
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
            return matchCount + MATCH_MESSAGE
                    + PREFIX_BRACKET + prizeMoneyWithDelimiter + POST_BRACKET;
        }

        return matchCount + MATCH_MESSAGE + MATCH_BONUS_MESSAGE
                + PREFIX_BRACKET + prizeMoneyWithDelimiter + POST_BRACKET;
    }
}
