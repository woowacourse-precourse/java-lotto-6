package lotto.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest extends NsTest {
    @Test
    @DisplayName("사용자가 숫자를 입력 시, 숫자가 아닌 값을 입력할 경우 예외가 발생한다.")
    public void inputMoneyTypeExceptionTest() throws Exception {
        // given
        String input = "1000j";
        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Override
    protected void runMain() {
        InputUtil.inputNumber();
    }
}
