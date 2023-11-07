package lotto.domain.prize;

import lotto.domain.result.Result;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int count;
    private final boolean bonus;
    private final int price;

    Prize(int count, boolean bonus, int price) {
        this.count = count;
        this.bonus = bonus;
        this.price = price;
    }

    public static Prize findPrize(Result result) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.count == result.count() && (!prize.bonus || result.isBonus()))
                .findFirst()
                .orElse(NONE);
    }

    public int getPrice() {
        return price;
    }
}