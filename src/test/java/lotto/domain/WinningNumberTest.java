package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    WinningNumber winningNumber;

    @BeforeEach
    void init() {
        winningNumber = new WinningNumber();
    }

    @Test
    @DisplayName("보너스 번호 당첨 번호 중복 예외 발생")
    void bonusNumberDuplicate() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 4;

        // When
        winningNumber.createWinningNumber(numbers);

        // Then
        assertThatThrownBy(() -> winningNumber.creatBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_BONUS_NUMBER_WINNER_NUMBER_DUPLICATE);
    }

    @Test
    @DisplayName("보너스 번호 범위 예외 발생")
    void bonusNumberRange() {
        // Given
        int bonusNumber = 50;

        // When
        // Then
        assertThatThrownBy(() -> winningNumber.creatBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_NUMBER_RANGE);
    }
}