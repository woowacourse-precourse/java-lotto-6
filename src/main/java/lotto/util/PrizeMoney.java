package lotto.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 해당 등수의 상금에 관한 정보를 저장한다.
 */
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

    /**
     * 특정 등수의 상금을 반환한다.
     *
     * @param prize 등수
     * @return 해당 등수의 상금
     */
    public static Integer getPrizeMoney(Integer prize) {
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            if (prizeMoney.prize.equals(prize)) {
                return prizeMoney.prizeMoney;
            }
        }
        return null;
    }

    /**
     * 출력 형식에 맞게 상금을 반환한다.
     *
     * @param prize 등수
     * @return 해당 등수의 상금 (ex - 1,000,000)
     */
    public static String getFormattedPrizeMoney(Integer prize) {
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            if (prizeMoney.prize.equals(prize)) {
                return NumberFormat.getNumberInstance(Locale.KOREAN).format(prizeMoney.prizeMoney);
            }
        }
        return null;
    }
}
