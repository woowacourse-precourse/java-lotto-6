package lotto.model;

import lotto.model.InputValidator;
import org.junit.jupiter.api.Test;

import static lotto.model.InputValidator.validateDivisibleByThousand;
import static lotto.model.InputValidator.validateNonInteger;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    public void 입력_검증_정수_변환_테스트() {
        String input = "1a2b3c";
        assertThrows(IllegalArgumentException.class, () -> {
            validateNonInteger(input);
        });
    }

    @Test
    public void 입력_검증_천의_배수_테스트() {
        String input = "12300";
        assertThrows(IllegalArgumentException.class, () -> {
            validateDivisibleByThousand(Integer.parseInt(input));
        });
    }

    @Test
    public void 쉼표_구분자_아닌_경우_테스트() {
        String input = "1 15 16 18 25 45";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateContainsCommaSeparator(input);
        });
    }

    @Test
    void 당첨번호에_중복이_있는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateDuplicateNumber("1,11,12,33,11,15");
        });
    }

    @Test
    void 보너스_번호가_일과_사십오사이의_수가_맞는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateBonusNumberInOneToFortyFive("0");
        });
    }
}
