package lotto;

import lotto.Input.PriceCheck;
import lotto.Input.RangeCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputTest {
    @Nested
    @DisplayName("구입 금액 테스트")
    class TestPriceCheck {
        @DisplayName("구입 금액에 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"abcd"})
        void inputWithNonDigits(String input) {
            assertThatThrownBy(() -> PriceCheck.validatePrice(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("구입 금액에 1000으로 나누어 떨어지지 않는 수가 들어오면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1999"})
        void inputWhichCanNotDivided(String input) {
            assertThatThrownBy(() -> PriceCheck.validatePrice(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("구입 금액에 빈 입력값이 들어오지 않으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {""})
        void inputEmpty(String input) {
            assertThatThrownBy(() -> PriceCheck.validatePrice(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("로또 번호 테스트")
    class TestRange {
        @DisplayName("번호에 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"abcd"})
        void inputWithNonDigits(String input) {
            assertThatThrownBy(() -> RangeCheck.validateRange(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1보다 작거나 45보다 큰 번호가 들어오면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"0", "55"})
        void inputOutOfRange(String input) {
            assertThatThrownBy(() -> RangeCheck.validateRange(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1보다 작거나 45보다 큰 번호가 들어오면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {""})
        void inputEmpty(String input) {
            assertThatThrownBy(() -> RangeCheck.validateRange(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
