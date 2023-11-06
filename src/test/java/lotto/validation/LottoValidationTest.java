package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidationTest {

    @Test
    void 로또_입력값이_숫자가_아니면_예외처리() {
        String input = "three";

        assertThatThrownBy(() -> LottoValidation.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
    }
}
