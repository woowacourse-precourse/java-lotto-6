package lotto.util;

import java.text.NumberFormat;
import java.util.Locale;

public enum PrizeMoney {
    FIRST_PRIZE_MONEY(1, 2_000_000_000),
    SECOND_PRIZE_MONEY(2, 30_000_000),
    THIRD_PRIZE_MONEY(3, 1_500_000),
    FOURTH_PRIZE_MONEY(4, 50_000),
    FIFTH_PRIZE_MONEY(5, 5_000);

    private final Integer prize;
    private final Integer prizeMoney;

    PrizeMoney(Integer prize, Integer prizeMoney) {
        this.prize = prize;
        this.prizeMoney = prizeMoney;
    }

    public static Integer getPrizeMoney(Integer prize) {
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            if (prizeMoney.prize.equals(prize)) {
                return prizeMoney.prizeMoney;
            }
        }
        return null;
    }

    public static String getFormattedPrizeMoney(Integer prize) {
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            if (prizeMoney.prize.equals(prize)) {
                return NumberFormat.getNumberInstance(Locale.KOREAN).format(prizeMoney.prizeMoney);
            }
        }
        return null;
    }
}
