package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    // private static final String ERROR_MESSAGE = "[ERROR]";
    
    @DisplayName("당첨 번호 중 보너스 번호와 중복되는 번호가 있으면 예외가 발생한다.")
    @Test
    void validateBonusNumberWithDuplicateNumber() {
        InputManager inputManager = new InputManager();
        int bonusNumber = 2;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    
        assertThatThrownBy(() -> inputManager.validateBonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void validateBonusNumberWithNumberLessThanOne() {
        InputManager inputManager = new InputManager();
        int bonusNumber = 0;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> inputManager.validateBonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void validateBonusNumberWithNumberGreaterThanFortyFive() {
        InputManager inputManager = new InputManager();
        int bonusNumber = 46;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> inputManager.validateBonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
