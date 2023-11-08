package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        // 로또 당첨 번호를 먼저 초기화
        winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("생성자를 통해 제대로 생성하는지 테스트")
    void constructorShouldAcceptValidBonusNumber() {
        // Given
        String input = "7"; // Assuming 7 is not in the winning numbers

        // When
        BonusNumber bonusNumber = new BonusNumber(input, winningNumbers);

        // Then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("잘못된 형식으로 입력했을 때 테스트")
    void constructorShouldThrowExceptionForInvalidInputFormat() {
        // Given
        String input = "a";

        // Then
        assertThatThrownBy(() -> new BonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바른 입력 형식이 아닙니다.");
    }

    @Test
    @DisplayName("로또 당첨번호랑 중복되는 숫자 입력되었을 때 테스트")
    void constructorShouldThrowExceptionForDuplicateWithWinningNumbers() {
        // Given
        String input = "1"; // 1 is already in the winning numbers

        // Then
        assertThatThrownBy(() -> new BonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호와 보너스 번호가 중복 됩니다.");
    }

    @Test
    @DisplayName("올바른 숫자 범위를 넘어간 입력을 받았을 때 테스트")
    void constructorShouldThrowExceptionForNumberOutOfRange() {
        // Given
        String input = "46"; // Assuming 46 is out of range

        // Then
        assertThatThrownBy(() -> new BonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
    }
}
