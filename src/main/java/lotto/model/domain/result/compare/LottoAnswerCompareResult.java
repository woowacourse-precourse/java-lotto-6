package lotto.model.domain.result.compare;

import java.util.Objects;

/**
 * Lotto와 보너스 숫자를 가진 LottoAnswer를 비교한 결과를 나타내기 위한 클래스
 */
public class LottoAnswerCompareResult extends LottoCompareResult {

    boolean collectBonus;

    public LottoAnswerCompareResult(int collectCount, boolean collectBonus) {
        super(collectCount);
        this.collectBonus = collectBonus;
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
