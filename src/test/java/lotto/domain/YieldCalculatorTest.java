package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YieldCalculatorTest {

    @Test
    @DisplayName("로또 갯수와 당첨된 로또들로 수익률을 계산한다.")
    void calculate_yield() {
        // given
        Map<Rank, Integer> winningLottoTable = initRankTable();
        long lottoCnt = 7;

        YieldCalculator calculator = new YieldCalculator();

        // when
        String yield = calculator.calculate(winningLottoTable, lottoCnt);

        // then
        assertThat(yield).isEqualTo("71.4%");
    }

    private Map<Rank, Integer> initRankTable() {
        Map<Rank, Integer> winningLottoTable = new HashMap<>();
        winningLottoTable.put(FIFTH, 1);
        winningLottoTable.put(NOTHING, 6);
        return winningLottoTable;
    }
}
