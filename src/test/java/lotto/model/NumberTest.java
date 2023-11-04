package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @DisplayName("1~45 숫자 범위를 벗어나는 경우 예외 발생 테스트")
    @Test
    void of() {
        int validNumber_min = -1;
        int validNumber_max = 46;
        assertThrows(IllegalArgumentException.class, () -> Number.of(validNumber_min));
        assertThrows(IllegalArgumentException.class, () -> Number.of(validNumber_max));

    }
}