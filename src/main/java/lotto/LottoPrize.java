package lotto;

import java.text.MessageFormat;
import java.text.NumberFormat;

public enum LottoPrize {
    NONE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false),
    ;

    private final int cashPrize;
    private final int hitTimes;
    private final boolean hitBonus;

    LottoPrize(int cashPrize, int hitTimes, boolean hitBonus) {
        this.cashPrize = cashPrize;
        this.hitTimes = hitTimes;
        this.hitBonus = hitBonus;
    }

    static LottoPrize of(int hitTimes, boolean hitBonus) {
        if (hitTimes == 6) {
            return FIRST;
        }
        if (hitTimes == 5) {
            if (hitBonus) {
                return SECOND;
            }
            return THIRD;
        }
        if (hitTimes == 4) {
            return FOURTH;
        }
        if (hitTimes == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public String say() {
        String commaCashPrize = NumberFormat.getInstance().format(cashPrize);
        if (hitBonus) {
            return MessageFormat.format("{0}개 일치, 보너스 볼 일치 ({1}원)", hitTimes, commaCashPrize);
        }
        return MessageFormat.format("{0}개 일치 ({1}원)", hitTimes, commaCashPrize);
    }

    public int getCashPrize() {
        return cashPrize;
    }
}
