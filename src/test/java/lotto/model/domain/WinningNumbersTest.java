package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    private WinningNumbers winningNumbers;

    @DisplayName("당첨번호와 보너스 번호가 입력한 그대로 가져오는지 테스트한다.")
    @Test
    void getWinningNumbers() {
        // Arrange
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        int bonus = 7;
        // Act
        winningNumbers = new WinningNumbers(lotto, bonus);
        // Assert
        assertThat(winningNumbers.getLotto()).isEqualTo(lotto);
        assertThat(winningNumbers.getBonus()).isEqualTo(bonus);
    }

    @DisplayName("보너스 번호가 당첨번호와 같으면 예외가 발생한다.")
    @Test
    void duplicateBonusNumber() {
        // Arrange
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        int bonus = 6;

        // Assert
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}