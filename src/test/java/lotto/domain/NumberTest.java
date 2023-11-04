package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Number 클래스")
class NumberTest {

    @DisplayName("번호가 1 미만 45 초과라면 예외를 발생한다")
    @Test
    void createNumberByOutOfRange() {
        assertThatThrownBy(() -> new Number(0))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Number(46))
            .isInstanceOf(IllegalArgumentException.class);
    }
}