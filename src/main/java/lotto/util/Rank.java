package lotto.util;

import java.util.Arrays;

public enum Rank {
    FIRST(LottoConst.FIRST_PLACE_COUNT, LottoConst.FIRST_PLACE_PRIZE),
    SECOND(LottoConst.SECOND_PLACE_COUNT, LottoConst.SECOND_PLACE_PRIZE),
    THIRD(LottoConst.THIRD_PLACE_COUNT, LottoConst.THIRD_PLACE_PRIZE),
    FOURTH(LottoConst.FOURTH_PLACE_COUNT, LottoConst.FOURTH_PLACE_PRIZE),
    FIFTH(LottoConst.FIFTH_PLACE_COUNT, LottoConst.FIFTH_PLACE_PRIZE);

    private int matchCount;
    private int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank getRank(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        String matchOfNumResult = this.getMatchCount() + "개 일치";

        if (this == Rank.SECOND) {
            matchOfNumResult += ", 보너스 볼 일치";
        }

        return matchOfNumResult;
    }
}
