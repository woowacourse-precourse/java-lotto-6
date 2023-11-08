package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicate() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverRangeWinningNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 50), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 size가 6 이상이면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}