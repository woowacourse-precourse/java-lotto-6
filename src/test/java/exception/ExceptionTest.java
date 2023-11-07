package exception;

import static exception.InputException.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @DisplayName("숫자가 아니라면 예외가 발생")
    @Test
    void valueByNumber() {
        assertThatThrownBy(() -> validateInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000 단위의 숫자가 아니라면 예외가 발생")
    @Test
    void numberByPayUnit() {
        assertThatThrownBy(() -> validatePayUnit(-2000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1-45 사이의 숫자가 아니라면 예외 발생")
    @Test
    void numberByInRange() {
        assertThatThrownBy(() -> validateRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
