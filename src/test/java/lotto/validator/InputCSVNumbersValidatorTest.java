package lotto.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputCSVNumbersValidatorTest {

    @Test
    public void 숫자들을_입력받을수_있다() {
        // Given
        List<String> inputs = Arrays.asList("1", "2", "3", "4", "5");
        // When & Then
        assertDoesNotThrow(() -> InputCSVNumbersValidator.validate(inputs));
    }

    @Test
    public void 하나라도_숫자가_아닌값이_입력되면_예외발생() {
        // Given
        List<String> inputs = Arrays.asList("1", "two", "3", "4", "5");
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(() -> InputCSVNumbersValidator.validate(inputs))
                .withMessageContaining("숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    public void 하나라도_음수가_입력되면_예외발생() {
        // Given
        List<String> inputs = Arrays.asList("1", "-2", "3", "4", "5");
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(() -> InputCSVNumbersValidator.validate(inputs))
                .withMessageContaining("음수가 입력되었습니다.");
    }
}
