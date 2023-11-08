package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumbersTest {

    @DisplayName("숫자가 아닌 값을 입력할 때, 예외를 발생한다")
    @Test
    void 숫자가_아닌_입력값() {
        String[] firstUserInput = {"1", "2", "a", "4", "5", "6"};
        String[] secondUserInput = {"1", "2.3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinNumbers(firstUserInput))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbers(secondUserInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 6개를 입력하지 않으면, 예외를 발생한다")
    @Test
    void 당첨번호_개수_테스트() {
        String[] userInput = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> new WinNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_중복_테스트() {
        String[] userInput = {"1", "2", "3", "4", "5", "3"};
        assertThatThrownBy(() -> new WinNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
