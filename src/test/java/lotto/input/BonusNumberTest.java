package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.BonusNumberDuplicateException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.NotIntegerException;
import lotto.validation.InputValidator;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 보너스_번호가_1이상_45이하가_아닌_경우_예외가_발생한다() {
        String bonusNumber = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(LottoNumberRangeException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아닌_경우_예외가_발생한다() {
        String bonusNumber = "bonusNumber";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(NotIntegerException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복인_경우_예외가_발생한다() {
        String bonusNumber = "6";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(BonusNumberDuplicateException.class);
    }
}
