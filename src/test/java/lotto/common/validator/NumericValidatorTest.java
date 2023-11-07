package lotto.common.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericValidatorTest {

    @DisplayName("validateDivisible는 dividend가 divisor로 나눠 떨어지는지 검증할 수 있다.")
    @Test
    void validateDivisible() {
        // given
        int dividend = 30000;
        int divisor = 1000;

        // when & then
        assertThatCode(() -> NumericValidator.validateDivisible(
                dividend,
                divisor,
                "Dividend %d is not divisible by divisor %d.".formatted(dividend, divisor)
        )).doesNotThrowAnyException();
    }

    @DisplayName("validateDivisible는 dividend가 divisor로 나눠 떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void validateDivisible_exception() {
        // given
        int dividend = 30000;
        int divisor = 1001;

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> NumericValidator.validateDivisible(
                                dividend,
                                divisor,
                                "Dividend %d is not divisible by divisor %d.".formatted(dividend, divisor)
                        )
                );
    }

}