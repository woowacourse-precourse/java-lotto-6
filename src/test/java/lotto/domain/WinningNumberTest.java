package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("당첨 번호가 숫자가 아닐 때 예외 발생한다.")
    @Test
    void createWinningNumber() {
        String input = "1,2,3,e,4,5";

        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
