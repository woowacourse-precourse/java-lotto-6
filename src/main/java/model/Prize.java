package model;

import java.util.Arrays;

public enum Prize {
    ST1(6, false, 2_000_000_000),
    ND2(5, true, 30_000_000),
    RD3(5, false, 1_500_500),
    TH4(4, false, 50_000),
    TH5(3, false, 5_000),
    NO(0, false, 0);

    private final int winNumberCount;
    private final int price;
    private final boolean bonus;

    Prize(int winNumberCount, boolean bonus, int price) {
        this.winNumberCount = winNumberCount;
        this.price = price;
        this.bonus = bonus;
    }

    public static Prize of(final int sameCount, final boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.winNumberCount == sameCount && prize.bonus == bonus)
                .findFirst()
                .orElse(Prize.NO);
    }

}
