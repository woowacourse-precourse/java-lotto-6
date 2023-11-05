package lotto.model.domain.result;

import java.util.Objects;

public class CompareResult{
    private int collectNumber;
    private boolean isCollectBonus;

    public CompareResult(int collectNumber, boolean isCollectBonus) {
        this.collectNumber = collectNumber;
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
        return collectNumber == that.collectNumber && isCollectBonus == that.isCollectBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectNumber, isCollectBonus);
    }
}