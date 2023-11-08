package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByNotNumber() {
        assertThatThrownBy(() -> new WinningNumber("check"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumber("0, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
