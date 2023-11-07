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
}