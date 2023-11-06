package lotto;

import lotto.Model.Rank;
import lotto.Model.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("당첨결과가 초기화 되는지 테스트")
    @Test
    void createResult() {
        Result result = new Result();

        Assertions.assertThat(result.getRankAndCounting().size()).isEqualTo(Rank.values().length);
    }

    @DisplayName("당첨 등수에 따른 당첨 금액 계산 테스트")
    @Test
    void calculateTotalSum() {
        Result result = new Result();

        result.getRankAndCounting().put(Rank.FIFTH, 1);
        result.getRankAndCounting().put(Rank.FOURTH, 2);

        int expected = 105000;
        Assertions.assertThat(result.calculateTotalSum()).isEqualTo(expected);
    }
}
