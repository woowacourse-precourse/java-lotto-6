package lotto;

import domain.lotto.WinningNumber;
import org.junit.jupiter.api.Test;

import static global.NumberDefinition.END_INCLUSIVE;
import static global.NumberDefinition.START_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    void 숫자가_1미만일때_예외_던지는지_확인() {
        assertThatThrownBy(() -> new WinningNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 범위 밖임");
    }

    @Test
    void 숫자가_45초과일때_예외_던지는지_확인() {
        assertThatThrownBy(() -> new WinningNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 범위 밖임");
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
