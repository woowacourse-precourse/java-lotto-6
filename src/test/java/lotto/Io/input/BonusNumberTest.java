package lotto.Io.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validation.InputValidator;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 보너스_번호가_1이상_45이하가_아닌_경우_예외가_발생한다() {
        String bonusNumber = "46";
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아닌_경우_예외가_발생한다() {
        String bonusNumber = "bonusNumber";
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
