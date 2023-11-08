package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createNumberByInvalidRange() {
        assertThatThrownBy(() -> new Number(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Number(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}