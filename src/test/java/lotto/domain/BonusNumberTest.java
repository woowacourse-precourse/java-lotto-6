package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BonusNumber의")
class BonusNumberTest {

    @Test
    @DisplayName("입력 받은 숫자가 범위를 넘어가면 예외를 던지는가")
    void over_range() {
        //given
        final Integer input = 46;

        //when & then
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 받은 숫자가 범위내면 예외를 던지지 않는가")
    void no_exception() {
        //given
        final Integer input = 1;

        //when & then
        assertThatNoException().isThrownBy(() -> new BonusNumber(input));
    }
}
