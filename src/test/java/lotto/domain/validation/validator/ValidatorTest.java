package lotto.domain.validation.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("입력값이 Integer 형식이 아니면 예외가 발생한다.")
    @Test
    void isInputInteger() {
        // Given
        String input = "a";

        // When
        boolean isInteger = validator.isInputInteger(input);

        // Then
        assertThat(isInteger).isFalse();
    }

    @DisplayName("입력값이 음수이면 예외가 발생한다.")
    @Test
    void isPurchaseAmountPositive() {
        // Given
        String input = "-1";

        // When, Then
        assertThatThrownBy(() -> validator.isPurchaseAmountPositive(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void isPurchaseAmountDividedUp() {
        // Given
        String input = "1001";

        // When, Then
        assertThatThrownBy(() -> validator.isPurchaseAmountDividedUp(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1~45범위 밖에 있으면 예외가 발생한다.")
    @Test
    void checkBonusNumberInRange() {
        // Given
        String input = "46";

        // When, Then
        assertThatThrownBy(() -> validator.checkBonusNumberInRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 입력값이 존재 시 예외가 발생한다.")
    @Test
    void checkWinningNumberContainsBonusNumber() {
        // Given
        String input = "1";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // When, Then
        assertThatThrownBy(() -> validator.checkWinningNumberContainsBonusNumber(numbers, input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}