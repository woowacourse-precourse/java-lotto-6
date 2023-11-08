package lotto.model.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputBonusNumberTest {
    private static final String VALID_INPUT = "33";
    private static final String INVALID_INPUT_OUT_OF_RANGE = "319";
    private static final String INVALID_INPUT_NOT_AN_INTEGER = "하하";

    @Test
    @DisplayName("주어지는 문자열로 생성되는 객체 확인")
    void getInstanceTest() {
        InputBonusNumber testInput = InputBonusNumber.getInstance(VALID_INPUT);

        assertEquals(33, testInput.sendInputData());
    }

    @Test
    @DisplayName("1 이상 45 이하의 입력이 주어지지 않은 경우 예외 처리 테스트")
    void getInstanceExceptionTest1() {
        assertThatThrownBy(() -> InputBonusNumber.getInstance(INVALID_INPUT_OUT_OF_RANGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("1 이상 45 이하");
    }

    @Test
    @DisplayName("숫자 입력이 주어지지 않은 경우 예외 처리 테스트")
    void getInstanceExceptionTest2() {
        assertThatThrownBy(() -> InputBonusNumber.getInstance(INVALID_INPUT_NOT_AN_INTEGER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("정수가 아닙니다.");
    }
}