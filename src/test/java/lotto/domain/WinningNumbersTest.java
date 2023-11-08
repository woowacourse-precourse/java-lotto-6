package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @DisplayName("당첨번호가 6개를 초과하면 에러를 발생시킨다.")
    @Test
    void winningNumberOverSizeTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 중복되면 에러를 발생시킨다.")
    @Test
    void winningNumberDuplicateTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 1~45사이의 숫자가 아니면 에러를 발생시킨.")
    @Test
    void winningNumberOverRangeTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 56)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1~45사이의 숫자가 아니면 에러를 발생시킨다.")
    @Test
    void bonusNumberOverRangeTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(70))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 에러를 발생시킨다.")
    @Test
    void bonusNumberDuplicateTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)).setBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
