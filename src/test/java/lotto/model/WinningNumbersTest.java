package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void 당첨_번호는_1부터_45_사이_숫자이다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertDoesNotThrow(() -> new WinningNumbers(numbers, bonusNumber));
    }

    @Test
    void 당첨_번호가_1부터_45_사이_숫자가_아닐_경우_예외를_발생시킨다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        Integer bonusNumber = 7;
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호가_1부터_45사이_숫자가_아닐_경우_예외를_발생시킨다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 46;
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호_중_중복된_숫자가_존재할_경우_예외를_발생시킨다() {
        List<Integer> numbers = List.of(1, 1, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호 중 중복된 숫자가 존재합니다.");
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복될_경우_예외를_발생시킨다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 1;
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
    }
}