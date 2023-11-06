package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidationTest {

    @Test
    void validateNull() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = "";

        assertThatThrownBy(() -> lottoValidation.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 입력해주세요.");
    }

    @Test
    void validateGap() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = " 2000";

        assertThatThrownBy(() -> lottoValidation.validateGap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백 없이 입력해주세요.");
    }

    @Test
    void validateOnlyPositiveInteger() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = "-5000";

        assertThatThrownBy(() -> lottoValidation.validateOnlyPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음수를 제외한 숫자를 입력해주세요.");
    }

    @Test
    void validateThousandUnit() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = "4321";

        assertThatThrownBy(() -> lottoValidation.validateThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위로 입력해주세요.");
    }
}