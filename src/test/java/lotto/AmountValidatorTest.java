package lotto;

import lotto.validation.AmountValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AmountValidatorTest {

    @Test
    void 숫자가_아닌_입력값_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            AmountValidator.validateAmount("not_a_number")
        );
        assertEquals("[ERROR] 정수형 숫자만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 정수형_숫자가_아닌_입력값_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            AmountValidator.validateAmount("15000.1")
        );
        assertEquals("[ERROR] 정수형 숫자만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 천원_미만의_입력값_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            AmountValidator.validateAmount("800")
        );
        assertEquals("[ERROR] 구매 금액은 최소 1000원 입니다.", exception.getMessage());
    }

    @Test
    void 천원_단위가_아닌_입력값_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            AmountValidator.validateAmount("1050")
        );
        assertEquals("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.", exception.getMessage());
    }

    @Test
    void 올바른_입력값_테스트() {
        assertDoesNotThrow(() ->
            AmountValidator.validateAmount("3000")
        );
    }

    @Test
    void 천원_입력_테스트() {
        assertDoesNotThrow(() ->
            AmountValidator.validateAmount("1000")
        );
    }
}

