package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    @DisplayName("숫자의 값이 1이상 45이하인 경우 값을 그대로 저장한다.")
    void saveNumberValueInRangeGreaterOrEqual1AndLessThanEqual45() {
        //given
        int target = 1;
        //when
        Number number = new Number(target);
        //then
        assertThat(number)
            .extracting("value")
            .isEqualTo(target);
    }

    @Test
    @DisplayName("숫자의 값이 1미만인 경우 예외를 발생시킨다.")
    void throwExceptionNumberValueLess1() {
        //given
        int target = 0;
        //when //then
        assertThatThrownBy(() -> new Number(target))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 번호는 1이상 45이하의 수만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("숫자의 값이 45이상인 경우 예외를 발생시킨다.")
    void throwExceptionNumberValueGreater45() {
        //given
        int target = 46;
        //when //then
        assertThatThrownBy(() -> new Number(target))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 번호는 1이상 45이하의 수만 입력할 수 있습니다.");
    }
}