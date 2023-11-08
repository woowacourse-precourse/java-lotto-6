package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @DisplayName("로또 숫자의 범위는 1부터 45까지 이다.")
    @Test
    void validateRange() {
        // given
        String input = "10";

        // when, then
        assertThatCode(() -> LottoValidator.validateRange(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 숫자가 1 미만이면 예외가 발생한다.")
    @Test
    void validateRangeLessThanOne() {
        // given
        String input = "0";

        // when, then
        assertThatThrownBy(() -> LottoValidator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자가 45를 초과하면 예외가 발생한다.")
    @Test
    void validateRangeMoreThanFortyFive() {
        // given
        String input = "46";

        // when, then
        assertThatThrownBy(() -> LottoValidator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}