package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberInputValidatorTest {

    BonusNumberInputValidator bonusNumberInputValidator = new BonusNumberInputValidator();
    List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void 보너스_번호에_대한_입력값_검증() {
        assertThatThrownBy(() -> bonusNumberInputValidator.validate("a", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 숫자가 아닙니다.");

        assertThatThrownBy(() -> bonusNumberInputValidator.validate("0", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 1과 45 사이여야 합니다.");

        assertThatThrownBy(() -> bonusNumberInputValidator.validate("6", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 당첨번호와 중복되지 않아야 합니다.");

    }
}