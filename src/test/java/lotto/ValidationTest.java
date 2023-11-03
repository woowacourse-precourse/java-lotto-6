package lotto;

import lotto.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
@DisplayName("Validation 클래스 테스트")
class ValidationTest {
    @Test
    void 문자열_숫자_검증() {
        // 정상적인 경우, 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> Validation.validateStringToInteger("123"));
    }

    @Test
    void 문자열_숫자_검증_실패() {
        // 예외가 발생해야 하는 경우
        assertThrows(IllegalArgumentException.class, () -> Validation.validateStringToInteger("abc"));
    }
}
