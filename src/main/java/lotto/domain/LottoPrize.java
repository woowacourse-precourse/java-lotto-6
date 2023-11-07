package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum LottoPrize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ETC(0, 0);

    private final int prizeRank;
    private final double prizeMoney;

    LottoPrize(int matchCount, double prizeMoney) {
        this.prizeRank = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeRank() {
        return prizeRank;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(it -> it.prizeRank == matchCount)
                .findFirst()
                .orElse(ETC);
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "(" + formatter.format(prizeMoney) + "원)";
    }
}