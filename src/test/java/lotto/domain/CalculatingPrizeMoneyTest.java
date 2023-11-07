package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatingPrizeMoneyTest {

    @Test
    @DisplayName("payPrize 메서드가 예외를 던지지 않아야 함")
    void payPrizeMethodDoesNotThrowException() {
        CalculatingPrizeMoney calculatingPrizeMoney = new CalculatingPrizeMoney();
        Map<Integer, Integer> lottoWinningCounters = new HashMap<>();
        assertThatCode(() -> calculatingPrizeMoney.payPrize(lottoWinningCounters)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("calculate 메서드가 예외를 던지지 않아야 함")
    void calculateMethodDoesNotThrowException() {
        CalculatingPrizeMoney calculatingPrizeMoney = new CalculatingPrizeMoney();
        Map<Integer, Integer> lottoWinningCounters = new HashMap<>();
        assertThatCode(() -> calculatingPrizeMoney.calculate(lottoWinningCounters)).doesNotThrowAnyException();
    }

}
