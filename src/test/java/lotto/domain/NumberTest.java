package lotto.domain;

import static lotto.global.exception.ErrorMessage.INVALID_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    @DisplayName("같은 값을 가지는 객체에 대해서 true, 다른 값을 가지는 객체에 대해서 false를 반환한다.")
    public void equals_메서드_테스트() {
        Number number1 = Number.valueOf(1);
        Number number2 = Number.valueOf(1);
        Number number3 = Number.valueOf(2);

        assertEquals(number1, number2);
        assertNotEquals(number1, number3);
    }

    @Test
    @DisplayName("같은 해시코드를 가지는 객체에 대해서 true, 다른 해시코드를 가지는 객체에 대해서 false를 반환한다.")
    public void hashCode_메서드_테스트() {
        Number number1 = Number.valueOf(1);
        Number number2 = Number.valueOf(1);
        Number number3 = Number.valueOf(2);

        assertEquals(number1.hashCode(), number2.hashCode());
        assertNotEquals(number1.hashCode(), number3.hashCode());
    }

    @Test
    @DisplayName("로또 번호를 정상적으로 조회한다.")
    public void 로또_번호_조회_테스트() {
        Number number = Number.valueOf(1);
        int expectedValue = 1;

        assertEquals(expectedValue, number.getValue());
    }

    @Test
    @DisplayName("정상적인 로또 범위에 의해 객체가 성공적으로 생성된다.")
    public void 로또_범위_검증_성공() {
        int validValue = 1;

        assertDoesNotThrow(() -> Number.valueOf(validValue));
    }

    @Test
    @DisplayName("1보다 같거나 작은 로또 번호에 의해 오류가 반환된다.")
    public void 작은_로또_번호의_입력으로_검증_실패() {
        int invalidValue = 0;

        assertThatThrownBy(() -> Number.valueOf(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("45보다 큰 로또 번호에 의해 오류가 반환된다.")
    public void 큰_로또_번호의_입력으로_검증_실패() {
        int invalidValue = 46;

        assertThatThrownBy(() -> Number.valueOf(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR.getMessage());
    }
}
