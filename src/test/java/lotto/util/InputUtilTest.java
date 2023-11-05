package lotto.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputUtilTest extends NsTest {
    @Test
    @DisplayName("사용자가 로또 구매 금액 입력 시, 숫자가 아닌 값을 입력할 경우 예외가 발생한다.")
    public void inputMoneyTypeExceptionTest() throws Exception {
        // given
        // when
        // then
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains("[ERROR] 숫자를 입력해주세요.");
        });

    }

    @Test
    @DisplayName("사용자가 입력한 금액이 0원 이하일 경우 예외가 발생한다.")
    public void buyLottosRangeExceptionTest1() throws Exception {
        // given
        // when
        // then
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("[ERROR] 금액을 0원 이상 입력해주세요.");
        });

    }

    @Test
    @DisplayName("사용자가 입력한 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    public void buyLottosRangeExceptionTest2() throws Exception {
        // given
        // when
        // then
        assertSimpleTest(() -> {
            runException("10300");
            assertThat(output()).contains("[ERROR] 금액을 1000원 단위로 입력해주세요.");
        });

    }
    @Override
    protected void runMain() {
        InputUtil.inputMoney();
    }
}
