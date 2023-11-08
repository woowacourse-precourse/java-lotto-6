package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.ValidateNumber;
import org.junit.jupiter.api.Test;

public class ValidateNumberTest {
    @Test
    void 숫자인지_검증() {
        assertThatThrownBy(() -> ValidateNumber.isNumber("100o")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 검증_통과() {
        assertThatCode(() -> ValidateNumber.isNumber("1000")).doesNotThrowAnyException();
    }
}
