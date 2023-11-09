package lotto.domain;

import lotto.domain.lotto.WinningNumber;
import lotto.global.constant.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;

import static lotto.global.constant.NumberDefinition.END_INCLUSIVE;
import static lotto.global.constant.NumberDefinition.START_INCLUSIVE;
import static lotto.global.constant.exception.ExceptionMessage.NUMBERS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    void 숫자가_1미만일때_예외_던지는지_확인() {
        assertThatThrownBy(() -> new WinningNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 숫자가_45초과일때_예외_던지는지_확인() {
        assertThatThrownBy(() -> new WinningNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 숫자가_범위_내일_때_저장이_잘_되는지_확인() {
        for(int i = START_INCLUSIVE.getNumber(); i<= END_INCLUSIVE.getNumber(); i++) {
            int number = i;
            assertThatCode(() -> new WinningNumber(number))
                    .doesNotThrowAnyException();
        }
    }
}
