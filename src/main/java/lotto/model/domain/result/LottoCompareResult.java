package lotto.model.domain.result;

import java.util.Objects;

public final class LottoCompareResult {
    private final int collectCount;
    private final boolean isCollectBonus;

    public LottoCompareResult(int collectCount, boolean isCollectBonus) {
        this.collectCount = collectCount;
        this.isCollectBonus = isCollectBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCompareResult that = (LottoCompareResult) o;
        return collectCount == that.collectCount && isCollectBonus == that.isCollectBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectCount, isCollectBonus);
    }
}