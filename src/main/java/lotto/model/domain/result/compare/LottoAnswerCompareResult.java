package lotto.model.domain.result.compare;

import java.util.Objects;

public class LottoAnswerCompareResult extends LottoCompareResult {

    boolean collectBonus;

    public LottoAnswerCompareResult(int collectCount, boolean collectBonus) {
        super(collectCount);
        this.collectBonus = collectBonus;
    }

    private LottoAnswerCompareResult(int collectCount) {
        super(collectCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        LottoAnswerCompareResult that = (LottoAnswerCompareResult) o;
        return collectBonus == that.collectBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collectBonus);
    }
}
