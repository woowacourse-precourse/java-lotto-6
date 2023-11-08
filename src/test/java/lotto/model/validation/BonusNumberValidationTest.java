package lotto.model.validation;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.view.ExceptionMessage;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BonusNumberValidationTest {

    @DisplayName("보너스 번호가 정수가 아닐 경우 예외 발생")
    @Test
    void whenBonusNumberIsNotInteger_thenThrowException() {
        String invalidNumber = "abc";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumberValidation(invalidNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 자연수가 아닐 경우 예외 발생")
    @Test
    void whenBonusNumberIsNotNatural_thenThrowException() {
        String zeroNumber = "-1";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumberValidation(zeroNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR.getMessage());
    }

    @DisplayName("보너스 번호 범위를 벗어날 경우 예외 발생")
    @Test
    void whenBonusNumberIsOutOfRange_thenThrowException() {
        String outOfRangeNumber = "46";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumberValidation(outOfRangeNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_IN_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    @Test
    void whenBonusNumberIsInWinningNumbers_thenThrowException() {
        String duplicateNumber = "1";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumberValidation(duplicateNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 유효할 때 예외 없음")
    @Test
    void whenBonusNumberIsValid_thenNoExceptionThrown() {
        String validNumber = "7";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new BonusNumberValidation(validNumber, winningNumbers));
    }

    @DisplayName("보너스 번호가 유효하면 올바르게 할당")
    @Test
    void whenBonusNumberIsValid_thenCorrectlyAssigned() {
        String validNumber = "7";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation(validNumber, winningNumbers);
        assertThat(bonusNumberValidation.getBonusNumber()).isEqualTo(7);
    }
}
