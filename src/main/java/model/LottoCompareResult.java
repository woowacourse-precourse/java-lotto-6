package model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LottoCompareResult {

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

        if (hasNotBonusBallCondition(sameCountRank)) {
            return Optional.of(sameCountRank.get(0));
        }

        return sameCountRank.stream()
            .filter(lottoRank -> lottoRank.hasSameBonusBallCondition(isBonusNumberSame))
            .findFirst();
    }

    private boolean hasNotBonusBallCondition(final List<LottoRank> sameCountRank) {
        return sameCountRank.size() == 1;
    }
}
