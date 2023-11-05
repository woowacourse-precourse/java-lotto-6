package lotto.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateResultTest {
    private RateResult rateResult;

    @BeforeEach
    void setUp() {
        rateResult = new RateResult();
    }

    @Test
    void calculate() {
        // given
        Integer useMoney = 8000;
        Integer totalWinMoney = 5000;

        // when
        Double result = rateResult.calculate(useMoney, totalWinMoney);

        // than
        assertThat(result).isEqualTo(62.5);
    }
}