package lotto.model.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputWinnerNumbersTest {
    private static final String VALID_INPUT = "3,5,7,12,20,41";
    private static final String INVALID_INPUT_OUT_OF_RANGE = "1,5,500,3,4,2";
    private static final String INVALID_INPUT_CONTAINS_NON_INTEGER = "1,메 롱,2,3,4,5";
    private static final String INVALID_INPUT_CONTAINS_BLANK_ELEMENT = "1,,2,3,4,5";

    @Test
    @DisplayName("주어지는 문자열로 생성되는 객체 확인")
    void getInstanceTest() {
        InputWinnerNumbers testInput = InputWinnerNumbers.getInstance(VALID_INPUT);

        assertEquals(List.of(3, 5, 7, 12, 20, 41).toString(), testInput.toString());
    }

    @Test
    @DisplayName("주어진 문자열에 로또 번호가 될 수 없는 숫자가 포함되어 있는 경우 예외 처리 테스트")
    void getInstanceExceptionTest1() {
        assertThatThrownBy(() -> InputWinnerNumbers.getInstance(INVALID_INPUT_OUT_OF_RANGE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("1 이상 45 이하");
    }

    @Test
    @DisplayName("주어진 문자열이 숫자가 아닌 문자열이 포함되어 있는 경우 예외 처리 테스트")
    void getInstanceExceptionTest2() {
        assertThatThrownBy(() -> InputWinnerNumbers.getInstance(INVALID_INPUT_CONTAINS_NON_INTEGER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("정수가 아닙니다.");
    }

    @Test
    @DisplayName("주어진 입력이 빈 원소를 포함한 경우 예외 처리 테스트")
    void getInstanceExceptionTest3() {
        assertThatThrownBy(() -> InputWinnerNumbers.getInstance(INVALID_INPUT_CONTAINS_BLANK_ELEMENT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("빈 입력이 포함되어 있습니다.");
    }
}