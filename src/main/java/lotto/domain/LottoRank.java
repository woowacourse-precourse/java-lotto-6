package lotto.domain;

import java.util.List;
public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FORTH(3, 50000),
    FIFTH(2, 5000),
    NONE(0, 0);

    private int matchCount;
    private int prizeAmount;

    LottoRank(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }
}

