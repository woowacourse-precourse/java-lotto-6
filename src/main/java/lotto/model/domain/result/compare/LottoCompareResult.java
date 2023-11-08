package lotto.model.domain.result.compare;

import java.util.Objects;

public class LottoCompareResult {
    protected final int collectCount;

    public LottoCompareResult(int collectCount) {
        this.collectCount = collectCount;
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
        return collectCount == that.collectCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectCount);
    }
}