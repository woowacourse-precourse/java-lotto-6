package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    @DisplayName("유효한 당첨 번호와 보너스 번호가 주어졌을 때 정상 처리되어야 한다")
    void createWinningNumbersWithValidInput() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers numbers = new WinningNumbers(winningNumbers, bonusNumber);

        assertThat(numbers.getWinningNumbers()).containsExactlyInAnyOrderElementsOf(winningNumbers);
        assertThat(numbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("중복된 당첨 번호가 있을 경우 IllegalArgumentException 예외를 발생시켜야 한다")
    void createWinningNumbersWithDuplicateNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("유효 범위를 벗어난 보너스 번호가 주어졌을 때 IllegalArgumentException 예외를 발생시켜야 한다")
    void createWinningNumbersWithInvalidBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 50;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호 중 하나와 일치할 경우 IllegalArgumentException 예외를 발생시켜야 한다")
    void createWinningNumbersWithBonusNumberMatchingWinningNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}