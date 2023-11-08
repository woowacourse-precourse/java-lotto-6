package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {

    @DisplayName("당첨번호가 1~45 범위를 벗어나면 예외를 발생한다.")
    @Test
    void winningNumbersOutOfRange() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        int bonus = 7;

        // when & then
        assertThatThrownBy(() -> LottoWinningNumbers.of(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 중복되면 예외를 발생한다.")
    @Test
    void winningNumbersDuplicated() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1);
        int bonus = 7;

        // when & then
        assertThatThrownBy(() -> LottoWinningNumbers.of(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1~45 범위를 벗어나면 예외를 발생한다.")
    @Test
    void bonusNumberOutOfRange() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 46;

        // when & then
        assertThatThrownBy(() -> LottoWinningNumbers.of(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 예외를 발생한다.")
    @Test
    void bonusNumberDuplicated() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 6;

        // when & then
        assertThatThrownBy(() -> LottoWinningNumbers.of(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
