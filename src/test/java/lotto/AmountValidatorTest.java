package lotto;

import lotto.validate.AmountValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountValidatorTest {
    private AmountValidator amountValidator;

    @BeforeEach
    void setUp() {
        amountValidator = new AmountValidator();
    }

    @Nested
    class InvalidInput {

        @ParameterizedTest
        @ValueSource(strings = {"글자", "&*()", "-1234"})
        @DisplayName("자연수 입력이 아닌 경우 예외 처리")
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> amountValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"-2222222222", "2222222222"})
        @DisplayName("입력이 Int 범위가 아닌 경우 예외 처리")
        void Int_범위가_아닌_입력(String input) {
            assertThatThrownBy(() -> amountValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1230", "12001", "13300"})
        @DisplayName("입력이 1,000으로 나누어 떨어지지 않는 경우 예외 처리")
        void 천으로_나누어_떨어지지_않는_입력(String input) {
            assertThatThrownBy(() -> amountValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ValidInput {
        @ParameterizedTest
        @ValueSource(strings = {"1000", "20000", "123000"})
        @DisplayName("정상적인 입력 테스트")
        void 정상적인_입력(String input) {
            assertThatCode(() -> amountValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}
