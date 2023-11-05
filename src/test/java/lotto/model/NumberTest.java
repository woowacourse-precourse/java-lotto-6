package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @DisplayName("최소 숫자 범위를 벗어나는 경우 예외 발생 테스트")
    @Test
    void validMinimumRangeNumber() {
        assertThatThrownBy(() -> {
            Number.of(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE.get());

    }

    @DisplayName("최대 숫자 범위를 벗어나는 경우 예외 발생 테스트")
    @Test
    void validMaximumRangeNumber() {
        assertThatThrownBy(() -> {
            Number.of(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_RANGE.get());

    }
}