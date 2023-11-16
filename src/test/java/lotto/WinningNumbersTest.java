package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("validate 메서드에서 6개의 당첨 번호가 아닌 경우 예외가 발생해야 한다.")
    @Test
    void validateByInvalidSize() {
        List<Integer> invalidWinningNumbers = List.of(1, 2, 3, 4, 5); // 6개의 당첨 번호가 아닌 경우
        int bonusNumber = 6;
        assertThatThrownBy(() -> new WinningNumbers(invalidWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("validate 메서드에서 범위를 벗어난 당첨 번호가 있는 경우 예외가 발생해야 한다.")
    @Test
    void validateByOutOfRangeWinningNumber() {
        List<Integer> outOfRangeWinningNumbers = List.of(1, 2, 3, 4, 5, 46); // 범위를 벗어난 당첨 번호가 있는 경우
        int bonusNumber = 6;
        assertThatThrownBy(() -> new WinningNumbers(outOfRangeWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("validate 메서드에서 보너스 볼이 당첨 번호와 중복된 경우 예외가 발생해야 한다.")
    @Test
    void validateByDuplicatedBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicatedBonusNumber = 6; // 중복된 보너스 볼
        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
