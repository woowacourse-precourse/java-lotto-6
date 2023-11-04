package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.validate.Validate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    private Validate validate;

    @BeforeEach
    public void setUp() {
        validate = new Validate();
    }

    @Test
    public void 정수형_입력_예외() {
        // given
        String input = "1000원";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateInteger(input));
    }
}
