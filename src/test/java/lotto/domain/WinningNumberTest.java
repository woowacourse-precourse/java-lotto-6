package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("보너스 번호가 당첨 번호에 없으면 예외가 발생하지 않는다.")
    @Test
    void setBonusNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

        assertDoesNotThrow(() -> winningNumber.setBonusNumber(7));
    }

    @DisplayName("보너스 번호가 당첨 번호에 있으면 예외가 발생한다.")
    @Test
    void setBonusNumberByAlreadyPicked() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> winningNumber.setBonusNumber(1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
