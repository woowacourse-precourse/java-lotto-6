package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    private final int matchCount;
    private final boolean needBonusNumber;
    private final int winningMoney;

    LottoRank(int matchCount, boolean needBonusNumber, int winningMoney) {
        this.matchCount = matchCount;
        this.needBonusNumber = needBonusNumber;
        this.winningMoney = winningMoney;
    }

    public static Optional<LottoRank> valueOf(int matchCount, boolean isMatchBonusNumber) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.needBonusNumber == isMatchBonusNumber) {
                return Optional.of(rank);
            }
        }
        return Optional.empty();
    }

    public static List<LottoRank> valuesReverse() {
        List<LottoRank> lottoRanks = Arrays.asList(values());
        Collections.reverse(lottoRanks);
        return lottoRanks;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isNeedBonusNumber() {
        return needBonusNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
