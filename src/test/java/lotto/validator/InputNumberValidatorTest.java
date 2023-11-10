package lotto.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputNumberValidatorTest {

    @Test
    public void 숫자를_입력받을_수_있다() {
        // Given
        String input = "42";

        // When & Then
        assertThatNoException()
                .isThrownBy(() -> InputNumberValidator.validate(input));
    }

    @Test
    public void 숫자가_아닌값이_입력되면_예외발생() {
        // Given
        String input = "notANumber";

        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageContaining("숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    public void 음수가_입력되면_예외발생() {
        // Given
        String input = "-42";

        // When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputNumberValidator.validate(input))
                .withMessageContaining("음수가 입력되었습니다.");
    }
}
