package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusExceptionTest {
    BonusException bonusException;

    @BeforeEach
    void setUp(){
        bonusException = new BonusException();
    }
    @DisplayName("숫자가 아닌 경우 예외 발생")
    @Test
    void isItNumber() {
        String number = "a";

        assertThatThrownBy(() -> bonusException.isItNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("MAX 범위를 벗어난 입력일 경우 예외")
    @Test
    void isItCheckedRange_MAX_범위를_벗어난_경우() {
        String number = "46";

        assertThatThrownBy(() -> bonusException.isItCheckedRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("MIN 범위를 벗어난 경우 예외")
    @Test
    void isItCheckedRange_MIN_범위를_벗어난_경우() {
        String number = "0";

        assertThatThrownBy(() -> bonusException.isItCheckedRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일 숫자가 존재하는 경우 예외")
    @Test
    void isItContainSameNumber_동일_숫자가_존재하는_경우() {
        String number = "1";
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusException.isItContainSameNumber(number, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}