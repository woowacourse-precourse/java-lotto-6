package lotto.validation;

import lotto.system.ErrorMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AmountValidationTest {
    private final AmountValidation amountValidation = new AmountValidation();

    @Nested
    @DisplayName("checkNumeric 검증 테스트")
    class CheckNumeric {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"abc", "!@#", "   ", "ZXc", "ZXC", "%^&", "?\\"})
        void 숫자가_아닌_값을_테스트(String target) {
            assertThatThrownBy(() -> amountValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NOT_NUMERIC);
        }
    }

    @Nested
    @DisplayName("checkPositive 검증 테스트")
    class CheckPositive {
        @ParameterizedTest(name = "{0}가 입력되었을 떄")
        @ValueSource(strings = {"-1000", "-10000", "-3000", "-4000"})
        void 음수가_입력되었을때를_테스트(String target) {
            assertThatThrownBy(() -> amountValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NOT_POSITIVE);
        }
    }

    @Nested
    @DisplayName("checkDivisible 검증 테스트")
    class CheckDivisible {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"123", "1050", "1500", "11100", "12500", "9223372036854775807"})
        void 기준금액으로_나누어지지_않을때를_테스트(String target) {
            assertThatThrownBy(() -> amountValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NOT_DIVISIBLE);
        }
    }
}

