package lotto.model;

import static lotto.constants.Message.INVALID_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @DisplayName("당첨 로또 번호의 범위가 유효하지 않으면 예외가 발생한다.")
    @Test
    public void testConstructorInvalidWinningNumbersRange() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 55)), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("당첨 보너스 번호의 범위가 유효하지 않으면 예외가 발생한다.")
    @Test
    public void testConstructorInvalidBonusNumberRange() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }
}