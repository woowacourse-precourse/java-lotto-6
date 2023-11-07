package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExceptionTest {
    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception();
    }

    @Test
    void 인트변환_양수입력() {
        int result = exception.checkInt("1000");
        assertThat(result).isEqualTo(1000);
    }

    @Test
    void 인트변환_음수입력() {
        int result = exception.checkInt("-1000");
        assertThat(result).isEqualTo(-1000);
    }

    @Test
    void 인트변환_문자입력() {
        int result = exception.checkInt("test");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 단위1000_올바른입력() {
        boolean result = exception.checkAmount(2000, false);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 단위1000_잘못된입력() {
        boolean result = exception.checkAmount(2222, false);
        assertThat(result).isEqualTo(false);
    }
}