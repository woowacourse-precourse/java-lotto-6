package model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LottoCompareResult {

    private static final int NO_CONDITION_RANK_INDEX = 0;
    private static final int NO_CONDITION_RANK_SIZE = 1;

    private final long equalCount;
    private final boolean isBonusNumberSame;

    public LottoCompareResult(final long count, final boolean isSame) {
        this.equalCount = count;
        this.isBonusNumberSame = isSame;
    }

    public Optional<LottoRank> getResultRank() {
        List<LottoRank> sameCountRank = Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.hasSameCount(equalCount))
            .toList();

        if (!existRankToGet(sameCountRank)) {
            return Optional.empty();
        }

        if (hasNotBonusBallCondition(sameCountRank)) {
            return Optional.of(sameCountRank.get(NO_CONDITION_RANK_INDEX));
        }

        return sameCountRank.stream()
            .filter(lottoRank -> lottoRank.hasSameBonusBallCondition(isBonusNumberSame))
            .findFirst();
    }

    private boolean existRankToGet(final List<LottoRank> sameCountRank) {
        return !sameCountRank.isEmpty();
    }

    private boolean hasNotBonusBallCondition(final List<LottoRank> sameCountRank) {
        return sameCountRank.size() == NO_CONDITION_RANK_SIZE;
    }
}
