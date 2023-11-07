package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("1-45 이외의 숫자가 있으면 예외 발생")
    void createNumberOutOfRange() {
        assertThatThrownBy(() -> new Number("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값이 있으면 예외 발생")
    void createNumberByLetter() {
        assertThatThrownBy(() -> new Number("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}