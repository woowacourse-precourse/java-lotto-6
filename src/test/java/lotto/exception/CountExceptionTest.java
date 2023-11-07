package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CountExceptionTest {
    CountException countException;

    @BeforeEach
    void setUp() {
        countException = new CountException();
    }

    @DisplayName("숫자가 아닌 경우 예외 발생")
    @Test
    void isItNumber() {
        String number = "a";

        assertThatThrownBy(() -> countException.isItNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000의 단위 숫자가 아닌 경우 예외")
    @Test
    void isIt1000wonUnit() {
        String number = "100";

        assertThatThrownBy(() -> countException.isIt1000wonUnit(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수인 경우 예외")
    @Test
    void isItPositiveNumber() {
        String number = "-100";

        assertThatThrownBy(() -> countException.isItPositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }


}