package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createAmountByDivideNumber() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 0 이하면 예외가 발생한다.")
    @Test
    void createAmountByNegative() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 수익률 계산")
    @Test
    void calculateProfitRateTest() {
        Amount amount = new Amount(8000);
        double profitRate = amount.calculateProfitRate(5000);

        assertThat(profitRate).isEqualTo(62.5);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
