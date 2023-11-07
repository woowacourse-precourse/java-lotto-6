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

    @Test
    void validateCommaDivision() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = "1.2.3.4.5.6";

        assertThatThrownBy(() -> lottoValidation.validateCommaDivision(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 쉼표(,)를 기준으로 구분해주세요.");
    }

    @Test
    void validateBetween1And45() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> lottoValidation.validateBetween1And45(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
    }

    @Test
    void validateDuplicateNumber() {
        LottoValidation lottoValidation = new LottoValidation();
        String input = "1,2,3,4,33,33";

        assertThatThrownBy(() -> lottoValidation.validateDuplicateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
}