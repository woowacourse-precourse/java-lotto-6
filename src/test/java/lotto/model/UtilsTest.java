package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    public void 문자열이_숫자로_구성되어_있지_않으면_예외가_발생한다() {
        // given
        final String inputString = "s333";

        // then
        Assertions.assertThatThrownBy(() -> Utils.convertStringToInt(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}