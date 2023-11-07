package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningExceptionTest {
    WinningException winningException;
    @BeforeEach
    void setUp() {
        winningException = new WinningException();
    }

    @DisplayName("입력 리스트 개수가 6개가 아닌 경우")
    @Test
    void isItCountOfNumber() {
        String numbers = "1,2";

        assertThatThrownBy(() -> winningException.isItCountOfNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일 숫자가 입력된 경우")
    @Test
    void isItContainSameNumber() {
        String numbers = "1,2,3,4,5,5";

        assertThatThrownBy(() -> winningException.isItContainSameNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45이외의 숫자가 포함된 경우")
    @Test
    void isItCheckedRange() {
        String numbers = "1,2,3,4,5,46";

        assertThatThrownBy(() -> winningException.isItCheckedRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}