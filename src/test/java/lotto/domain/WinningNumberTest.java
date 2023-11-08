package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {
    @DisplayName("WinningNumber 객체를 생성할 수 있다.")
    @Test
    void createWinningNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        assertThat(winningNumber).isNotNull();
    }

    @DisplayName("WinningNumber 객체에서 당첨 번호를 가져올 수 있다.")
    @Test
    void getNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        List<Integer> result = winningNumber.getNumbers();

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("WinningNumber 객체에서 보너스 번호를 가져올 수 있다.")
    @Test
    void getBonusNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);

        int result = winningNumber.getBonusNumber();

        assertThat(result).isEqualTo(7);
    }
}