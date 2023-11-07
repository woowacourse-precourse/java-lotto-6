package lotto.exception;

import static lotto.exception.ErrorMessage.NOT_INTEGER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoExceptionTest {
    @DisplayName("예외 메시지가 올바르게 출력된다.")
    @Test
    void printException() {
        LottoException lottoException = LottoException.of(NOT_INTEGER);
        System.out.println(lottoException.getMessage());
    }
}
