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

    @Override
    protected void runMain() {
        InputUtil.inputNumber();
    }
}
