package lotto;

import static lotto.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 당첨번호_리스트의_크기가_6이_아닌_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
    }
}
