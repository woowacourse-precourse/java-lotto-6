package lotto.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidationExceptionTest {

    @Test
    @DisplayName("로또 유효성 검증 예외 메시지 테스트")
    void testExceptionMessage() {
        String testMessage = "테스트 메시지";
        LottoValidationException exception = new LottoValidationException(testMessage);

        assertEquals(testMessage, exception.getMessage());
    }
}