package lotto.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.exception.InputFormatException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.NotIntegerException;
import lotto.exception.WinningNumberDuplicateException;
import lotto.exception.WinningNumberSizeException;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 당첨_번호_중_1이상_45이하가_아닌_숫자가_있을_경우_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
            .isInstanceOf(LottoNumberRangeException.class);
    }

    @Test
    void 당첨_번호가_6개가_아닌_경우_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
            .isInstanceOf(WinningNumberSizeException.class);
    }

    @Test
    void 중복된_숫자가_있는_경우_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
            .isInstanceOf(WinningNumberDuplicateException.class);
    }

    @Test
    void 당첨_번호_중_숫자가_아닌_입력이_있으면_예외가_발생한다() {
        String input = "1,2,3,4,5,six";
        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersFormat(input))
                .isInstanceOf(NotIntegerException.class);
    }

    @Test
    void 입력_형식이_올바르지_않으면_예외가_발생한다() {
        String input1 = "1,2,,3,4,5,6";
        String input2 = ",1,2,3,4,5,6";
        String input3 = "1,2,3,4,5,6,";

        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersFormat(input1))
                .isInstanceOf(InputFormatException.class);

        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersFormat(input2))
                .isInstanceOf(InputFormatException.class);

        Assertions.assertThatThrownBy(() -> InputValidator.validateWinningNumbersFormat(input3))
                .isInstanceOf(InputFormatException.class);
    }
}
