package lotto.constant;

import java.util.Arrays;

public enum LottoMatch {
    NO(Integer.MIN_VALUE, 0L, "꽝 (0원) - %d개"),
    THREE(3, 5_000L, "3개 일치 (5,000원) - %d개"),
    FOUR(4, 1_500_000L, "4개 일치 (50,000원) - %d개"),
    FIVE(5, 1_500_000L, "5개 일치 (1,500,000원) - %d개"),
    BONUS(Integer.MAX_VALUE, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX(6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - %d개");

    private final int count;
    private final long amount;
    private final String formatter;

    LottoMatch(int count, long amount, String formatter) {
        this.count = count;
        this.amount = amount;
        this.formatter = formatter;
    }

    public static LottoMatch get(int count) {
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElse(NO);
    }

    public int count() {
        return count;
    }

    public long calculate(int count) {
        return amount * count;
    }

    public String result(int count) {
        return formatter.formatted(count);
    }
}
