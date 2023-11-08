package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {

    MISS(0, false, 0, ""),
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치");


    private final int count;
    private final boolean isSameBonus;
    private final int amount;
    private final String display;

    LottoRank(int count, boolean isSameBonus, int amount, String display) {
        this.count = count;
        this.isSameBonus = isSameBonus;
        this.amount = amount;
        this.display = display;
    }

    public static LottoRank calculate(int count, boolean isSameBonus) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.count == count && rank.isSameBonus == isSameBonus) {
                return rank;
            }
        }

        return MISS;
    }

    public static List<LottoRank> getLottoRank() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotMiss)
                .collect(Collectors.toList());
    }

    private static boolean isNotMiss(LottoRank lottoRank) {
        return lottoRank != MISS;
    }

    public int getCount() {
        return count;
    }

    public boolean isSameBonus() {
        return isSameBonus;
    }

    public int getAmount() {
        return amount;
    }

    public String getDisplay() {
        return display;
    }
}
