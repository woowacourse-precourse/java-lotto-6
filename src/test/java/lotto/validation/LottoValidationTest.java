package lotto.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidationTest {

    LottoValidation lottoValidation = new LottoValidation();
    @Test
    void validateNull() {
        String input = "";

        assertThatThrownBy(() -> lottoValidation.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 입력해주세요.");
    }

    @Test
    void validateGap() {
        String input = " 2000";

        assertThatThrownBy(() -> lottoValidation.validateGap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백 없이 입력해주세요.");
    }

    @Test
    void validateOnlyPositiveInteger() {
        String input = "-5000";

        assertThatThrownBy(() -> lottoValidation.validateOnlyPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음수를 제외한 숫자를 입력해주세요.");
    }

    @Test
    void validateThousandUnit() {
        String input = "4321";

        assertThatThrownBy(() -> lottoValidation.validateThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위로 입력해주세요.");
    }

    @Test
    void validateCommaDivision() {
        String input = "1.2.3.4.5.6";

        assertThatThrownBy(() -> lottoValidation.validateCommaDivision(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 쉼표(,)를 기준으로 구분해주세요.");
    }

    @Test
    void validateOnlyPositiveIntegerList() {
        String input = "dd,1,2,3,4,5";

        assertThatThrownBy(() -> lottoValidation.validateOnlyPositiveIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음수를 제외한 숫자를 입력해주세요.");
    }

    @Test
    void validateBetween1And45() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> lottoValidation.validateBetween1And45(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
    }

    @Test
    void validateDuplicateNumber() {
        String input = "1,2,3,4,33,33";

        assertThatThrownBy(() -> lottoValidation.validateDuplicateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void validateBetween1And45Bonus() {
        String input = "50";

        assertThatThrownBy(() -> lottoValidation.validateBetween1And45Bonus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
    }

    @Test
    void validateOverlapWinningNumber() {
        String input = "5";
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lottoValidation.validateOverlapWinningNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 겹치지 않는 숫자여야 합니다.");
    }
}