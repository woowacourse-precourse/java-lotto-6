package lotto.domain.winningNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("당첨 번호 입력 테스트")
public class WinningNumberTest {

    @DisplayName("당첨 번호 - 당첨 번호의 개수가 6개가 넘으면 예외 발생")
    @Test
    void testWinningNumberOverSize() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 - 당첨 번호가 중복되면 예외 발생")
    @Test
    void testWinningNumberDuplicateNumbers() {
        String input = "1,1,3,4,5,6";
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 - 숫자가 아닌 값이 있는 경우 예외 발생")
    @Test
    void testWinningNumberNotNumericInput() {
        String input = "a,2,3,4,5,6";
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 - 숫자가 범위를 벗어난 경우 예외 발생")
    @Test
    void testWinningNumberOutOfRange() {
        String input = "java1,2,3,4,5,66";
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 - 올바른 입력을 한 경우")
    @Test
    void testWinningNumber() {
        String input = "1,20,3,45,14,30";
        assertThatCode(() -> new WinningNumber(input))
                .doesNotThrowAnyException();
    }
}
