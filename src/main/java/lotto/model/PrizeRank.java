package lotto.model;
import lotto.util.Constants.*;

import static lotto.util.Constants.*;

public enum PrizeRank {
    FIRST(6, false, FIRST_PRICE),
    SECOND(5, true, SECOND_PRICE),
    THIRD(5, false, THIRD_PRICE),
    FOURTH(4, false, FOURTH_PRICE),
    FIFTH(3, false, FIFTH_PRICE);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int price;

    PrizeRank(int matchCount, boolean bonusMatch, int price) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.price = price;
    }

    public static PrizeRank findPrizeRankByMatches(int matchCount, boolean hasBonus) {
        for (PrizeRank rank : PrizeRank.values()) {
            if (rank.isWinningRank(matchCount, hasBonus)) {
                return rank;
            }
        }
        return null;
    }

    public boolean isWinningRank(int count, boolean hasBonus) {
        return this.matchCount == count && (!this.bonusMatch || hasBonus);
    }

    public int getPrice() {
        return price;
    }

}