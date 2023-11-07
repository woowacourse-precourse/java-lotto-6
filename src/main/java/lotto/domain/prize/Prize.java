package lotto.domain.prize;

import lotto.domain.result.Result;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - "),
    NONE(0, false, 0, "");

    private final int count;
    private final boolean bonus;
    private final int price;
    private final String msg;

    Prize(int count, boolean bonus, int price, String msg) {
        this.count = count;
        this.bonus = bonus;
        this.price = price;
        this.msg = msg;
    }

    public static Prize findPrize(Result result) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.count == result.count() && (!prize.bonus || result.isBonus()))
                .findFirst()
                .orElse(NONE);
    }

    public int getProfit() {
        return price;
    }

    public String getMsg() {
        return msg;
    }
}