package lotto.data;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCombinationTest {
    @Test
    @DisplayName("보너스 넘버가 당첨 번호에 포함되면 예외가 발생한다.")
    void createWinningNumbersByBonusNumberInWinning() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningCombination(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER.getMessage());
    }
}
