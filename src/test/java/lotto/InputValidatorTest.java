package lotto;

import lotto.model.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    public void 입력_검증_정수_변환_테스트() {
        String input = "1a2b3c";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonInteger(input);
        });
    }
}
