package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public enum LottoRank {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int winningMoney;

    LottoRank(int matchCount, boolean matchBonus, int winningMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Optional<LottoRank> calculateRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(rank, matchCount, matchBonus))
                .findFirst();
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static List<LottoRank> getLottoRanksDescendingOrder() {
        return Arrays.stream(values())
                .filter(rank -> rank != MISS)
                .sorted(Collections.reverseOrder())
                .toList();
    }

    private boolean isMatch(LottoRank lottoRank, int matchCount, boolean matchBonus) {
        return (lottoRank.matchCount == matchCount) && (lottoRank.matchBonus == matchBonus);
    }
}
