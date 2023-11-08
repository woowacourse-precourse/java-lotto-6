package lotto;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Rank {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    NO_RANK(0, false, 0);

    private final int matchCount;
    private final boolean bonus;
    private final int cashPrize;

    Rank(int matchCount, boolean bonus, int cashPrize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.cashPrize = cashPrize;
    }

    public static Rank getRank(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.bonus == bonus)
                .findAny()
                .orElse(NO_RANK);
    }

    public String getMessage() {
        String cashPrizeFormatted = cashPrizeFormatting();
        if (bonus) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + cashPrizeFormatted + "원) - ";
        }
        return matchCount + "개 일치 (" + cashPrizeFormatted + "원) - ";
    }

    private String cashPrizeFormatting() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(cashPrize);
    }

    public int getCashPrize() {
        return cashPrize;
    }
}