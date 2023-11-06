package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

class InputValidationTest {
    @Test
    void 입력받은_문자열이_숫자가_아니면_예외_처리() {
        assertThatThrownBy(() -> InputValidation.validateNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1999", "1001"})
    void 숫자가_나누어_떨어지지_않으면_예외_처리(int number) {
        assertThatThrownBy(() -> InputValidation.checkDivisible(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 나누어 떨어지지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "999"})
    void 금액이_부족한_경우_예외_처리(int number) {
        assertThatThrownBy(() -> InputValidation.checkSufficient(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액이 충분하지 않습니다.");
    }

    @EmptySource
    @ParameterizedTest
    @CsvSource(value = {"123456,"}, delimiter = ':')
    void 구분자를_기준으로_구분되어_있지_않은_경우(String input) {
        assertThatThrownBy(() -> InputValidation.checkDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구분자를 기준으로 구분되어 있지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "46"})
    void 범위에_맞지_않은_숫자가_있는_경우(int number) {
        assertThatThrownBy(() -> InputValidation.checkRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 범위에 맞지 않은 숫자가 있습니다.");
    }

    @Test
    void 입력받은_번호가_당첨번호와_중복된_경우() {
        Lotto numbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> InputValidation.checkOverlap(1, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 있습니다.");
    }
}