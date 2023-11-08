package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.validation.BonusNumberValidator;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValidatorTest {

    @Test
    void 보너스_숫자가_숫자가_아닌_경우_예외를_던진다() {
        String input = "abc";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(input, winningNumbers));
    }

    @Test
    void 보너스_숫자가_범위를_벗어난_경우_예외를_던진다() {
        String input = "47";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(input, winningNumbers));
    }

    @Test
    void 보너스_숫자가_당첨_번호와_중복된_경우_예외를_던진다() {
        String input = "6";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(input, winningNumbers));
    }

    @Test
    void 올바른_보너스_숫자가_입력된_경우_예외를_던지지_않는다() {
        String input = "7";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> BonusNumberValidator.validateBonusNumber(input, winningNumbers));
    }


}