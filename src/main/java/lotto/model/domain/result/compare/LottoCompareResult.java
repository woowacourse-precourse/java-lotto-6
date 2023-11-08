package lotto.model.domain.result.compare;

import java.util.Objects;

/**
 * Lotto 클래스들의 비교 결과를 나타내기 위한 클래스
 */
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