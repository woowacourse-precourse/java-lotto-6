package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PLACE(1, 6, 0, 2_000_000_000),
    SECOND_PLACE(2, 5, 1, 30_000_000),
    THIRD_PLACE(3, 5, 0, 1_500_000),
    FOURTH_PLACE(4, 4, 0, 50_000),
    FIFTH_PLACE(5, 3, 0, 5_000),
    OTHER_PLACE(0, 0, 0, 0);

    private final int rank;
    private final int matchCount;
    private final int matchBonusCount;
    private final int price;

    LottoRank(int rank, int matchCount, int matchBonusCount, int price) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.matchBonusCount = matchBonusCount;
        this.price = price;
    }

    public static LottoRank matchLottoRank(int matchCount, int matchBonusCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount
                        && lottoRank.matchBonusCount == matchBonusCount)
                .findAny()
                .orElse(OTHER_PLACE);
    }

    public int getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }
}
