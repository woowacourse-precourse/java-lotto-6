package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @DisplayName("1000으로 나누어 지지 않는 경우 예외가 발생한다.")
    @Test
    void createIndivisibleByThousand() {
        int payment = 1004;

        assertThatThrownBy(() -> new Validation().validatePayment(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersOverRange() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Validation().validateRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void createDuplicatedWinningNumbers() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,1);

        assertThatThrownBy(() -> new Validation().validateDuplication(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[보너스 번호]1~45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createBonusNumbersOverRange() {
        int bonusNumber = 57;

        assertThatThrownBy(() -> new Validation().validateBonusNumberRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[보너스 번호]당첨 번호와 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void createDuplicatedBonusNumbers() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 3;

        assertThatThrownBy(() -> new Validation().validateBonusNumberDuplication(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
