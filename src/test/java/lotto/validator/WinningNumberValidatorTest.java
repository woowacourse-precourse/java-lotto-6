package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningNumberValidatorTest {
    @ParameterizedTest
    @DisplayName("쉼표로 구분된 6개의 범위 내의 숫자는 예외 미발생")
    @ValueSource(strings = {"1,2,3,4,5,6", "10,24,32,11,45,1"})
    void validate6IntegerListInValidRange(String numbers) {
        assertDoesNotThrow(() -> WinningNumberValidator.validate(numbers));
    }

    @ParameterizedTest
    @DisplayName("쉼표로 구분된 리스트가 아니거나, 길이가 다른 경우 예외 발생")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "adbc,,"})
    void validateNotAnValidListWithLength6(String numbers) {
        assertThatThrownBy(() -> WinningNumberValidator.validate(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("쉼표로 구분된 문자가 숫자가 아니거나 범위가 올바르지 않을 경우 예외 발생")
    @ValueSource(strings = {"1,2,3,4,5,a", "1,2,3,4,5,46"})
    void validateListWidthInValidIntegers(String numbers) {
        assertThatThrownBy(() -> WinningNumberValidator.validate(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
