package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("총 상금이 올바르게 계산된다")
    @Test
    void makeTotalPrize() {
        Result result = new Result();
        result.addResult(Reward.FIFTH);
        result.addResult(Reward.FIFTH);
        result.addResult(Reward.FIRST);

        long actual = result.calculateTotalPrize(result);
        long expected = Reward.FIFTH.getPrize()* 2L + Reward.FIRST.getPrize();
        assertThat(actual).isEqualTo(expected);
    }

}