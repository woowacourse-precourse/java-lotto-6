package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {
    @DisplayName("입력한 금액이 숫자다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "10000"})
    public void validatePurchaseAmount_ValidInput(String input) {
        int result = InputValidation.validatePurchaseAmount(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력한 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "xyz"})
    public void validatePurchaseAmount_InvalidInput_NotNumeric(String input) {
        assertThatThrownBy(() -> InputValidation.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 번호가 숫자다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void validateWinningNumbers_ValidInput(String input) {
        String[] numbers = input.split(",");
        List<Integer> result = InputValidation.validateWinningNumbers(numbers);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("입력한 로또 번호가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,abc,6", "10,20,30,40,50,xyz"})
    public void validateWinningNumbers_InvalidInput(String input) {
        String[] numbers = input.split(",");
        assertThatThrownBy(() -> InputValidation.validateWinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스 넘버가 숫자다.")
    @ParameterizedTest
    @ValueSource(strings = {"7", "10", "15"})
    public void validateBonusNumber_ValidInput(String input) {
        int result = InputValidation.validateBonusNumber(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력한 보너스 넘버가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "xyz"})
    public void validateBonusNumber_InvalidInput(String input) {
        assertThatThrownBy(() -> InputValidation.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

