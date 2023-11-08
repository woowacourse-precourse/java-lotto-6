package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Model.Rank;
import lotto.Model.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private Result result;

    @BeforeEach
    void set(){
        result = new Result();
    }

    @DisplayName("당첨결과가 0으로 초기화 되는지 테스트")
    @Test
    void createDefalutResult() {
        List<Integer> actual = new ArrayList<>(result.getCountByWinningRank().values());
        List<Integer> expected = List.of(0, 0, 0, 0, 0, 0);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 등수에 따른 당첨 금액 계산 테스트")
    @Test
    void calculateTotalPrize() {
        Map<Rank, Integer> defaultResult = result.getCountByWinningRank();
        defaultResult.put(Rank.FIFTH, 1);
        defaultResult.put(Rank.FOURTH, 2);

        int expectedResult = 105000;
        Assertions.assertThat(result.calculateTotalPrize()).isEqualTo(expectedResult);
    }
}
