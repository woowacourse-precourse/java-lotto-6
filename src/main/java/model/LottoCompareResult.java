package model;

public class LottoCompareResult {

    private final long equalCount;
    private final boolean isBonusNumberSame;

    public LottoCompareResult(final long count, final boolean isSame) {
        this.equalCount = count;
        this.isBonusNumberSame = isSame;
    }
}
