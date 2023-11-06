package lotto.model;

import static lotto.constant.Rank.FIVE_AND_BONUS_MATCH;
import static lotto.constant.Rank.FIVE_MATCH;
import static lotto.constant.Rank.FOUR_MATCH;
import static lotto.constant.Rank.SIX_MATCH;
import static lotto.constant.Rank.THREE_MATCH;

import java.util.EnumMap;
import java.util.Map;
import lotto.constant.Rank;

public class RankMoney {
    private final Map<Rank, Integer> rankMoney;

    public RankMoney() {
        this.rankMoney = new EnumMap<>(Rank.class);
        this.rankMoney.put(THREE_MATCH, THREE_MATCH.prize);
        this.rankMoney.put(FOUR_MATCH, FOUR_MATCH.prize);
        this.rankMoney.put(FIVE_MATCH, FOUR_MATCH.prize);
        this.rankMoney.put(FIVE_AND_BONUS_MATCH, FIVE_AND_BONUS_MATCH.prize);
        this.rankMoney.put(SIX_MATCH, SIX_MATCH.prize);
    }

    public int getPrizeMoney(int matchCount) {
        return this.rankMoney.getOrDefault(Rank.getRankByMatchCount(matchCount), 0);
    }

    public int getBonusPrizeMoney(int matchCount, boolean isMatchBonus) {
        if (matchCount == 5 && isMatchBonus) {
            return 1500000;
        }
        return 0;
    }
}
