package lotto.Constants;

import static lotto.Constants.TurnOuts.TURN_OUT_RATE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TurnOutsTest {

    private static final Integer BUDGET = 1000;

    @DisplayName("수익률 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:100", "0:0", "10000:1000"}, delimiter = ':')
    void 수익률_계산_테스트(Integer totalPrize, Double expectedTurnOutRate) {
        Double turnOutRate = TURN_OUT_RATE.calculate(totalPrize, BUDGET);
        assertThat(turnOutRate).isEqualTo(expectedTurnOutRate);
    }
}
