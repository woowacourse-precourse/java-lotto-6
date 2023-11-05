package lotto.model.domain.result;

import java.util.Objects;

public class CompareResult{
    private int collectCount;
    private boolean isCollectBonus;

    public CompareResult(int collectCount, boolean isCollectBonus) {
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
        CompareResult that = (CompareResult) o;
        return collectCount == that.collectCount && isCollectBonus == that.isCollectBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectCount, isCollectBonus);
    }
}