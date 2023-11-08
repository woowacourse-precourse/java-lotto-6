package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    public void 빈_값_예외_발생() {
        assertThatThrownBy(() -> InputValidator.isNullOrIsEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자가_아닌_값_예외_발생() {
        assertThatThrownBy(() -> InputValidator.isNotDigit("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 양수가_아닌_값_예외_발생() {
        assertThatThrownBy(() -> InputValidator.isNotPositiveNumber("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구분자_이외_특수기호_있는_경우_예외_발생() {
        assertThatThrownBy(() -> InputValidator.includeSymbolExceptComma("1, 3/4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자가_아닌_원소가_있는_경우_예외_발생() {
        assertThatThrownBy(() -> InputValidator.isNotDigits(Arrays.asList("1","e","3","4")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자가_1개가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> InputValidator.isNotOneNumber("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}