package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구입 금액에 숫자가 아닌 다른 문자열을 입력하면 예외가 발생한다.")
    @Test
    void InputLottoMoneyByNotNumber() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액 단위가 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void InputWrongLottoMoneyUnit() {
        assertSimpleTest(() -> {
            runException("1100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
