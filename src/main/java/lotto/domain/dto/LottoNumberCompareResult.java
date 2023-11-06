package lotto.domain.dto;

public class LottoNumberCompareResult {
    int matchingCount;
    boolean bonusIncluded;

    private LottoNumberCompareResult(final int matchingCount, final boolean bonusIncluded) {
        this.matchingCount = matchingCount;
        this.bonusIncluded = bonusIncluded;
    }

    public static LottoNumberCompareResult of(int matchingCount, boolean bonusIncluded) {
        return new LottoNumberCompareResult(matchingCount, bonusIncluded);
    }
}
