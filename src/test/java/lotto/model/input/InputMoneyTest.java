package lotto.model.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputMoneyTest {
    private static final String VALID_INPUT = "3000";
    private static final String INVALID_INPUT_INDIVISIBLE_BY_UNIT = "319";
    private static final String INVALID_INPUT_NEGATIVE = "-11";
    private static final String INVALID_INPUT_NOT_AN_INTEGER = "하하";

    @Test
    @DisplayName("주어지는 문자열로 생성되는 객체 확인")
    void getInstanceTest() {
        InputMoney testInput = InputMoney.getInstance(VALID_INPUT);

        assertEquals(3000, testInput.sendInputData());
    }

    @Test
    @DisplayName("주어지는 문자열이 로또 가격으로 나누어지지 않는 경우 예외 처리 테스트")
    void getInstanceExceptionTest1() {
        assertThatThrownBy(() -> InputMoney.getInstance(INVALID_INPUT_INDIVISIBLE_BY_UNIT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("나누어 떨어지지 않습니다.");
    }

    @Test
    @DisplayName("양수로 입력이 주어지지 않은 경우 예외 처리 테스트")
    void getInstanceExceptionTest2() {
        assertThatThrownBy(() -> InputMoney.getInstance(INVALID_INPUT_NEGATIVE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("양수여야 합니다.");
    }

    @Test
    @DisplayName("숫자 입력이 주어지지 않은 경우 예외 처리 테스트")
    void getInstanceExceptionTest3() {
        assertThatThrownBy(() -> InputMoney.getInstance(INVALID_INPUT_NOT_AN_INTEGER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("정수가 아닙니다.");
    }
}