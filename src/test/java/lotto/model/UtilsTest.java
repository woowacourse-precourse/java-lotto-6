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

    @Test
    public void 숫자로_구성된_문자열_리스트에_문자가_있으면_예외가_발생한다() {
        // given
        final String numericString = "a,1,2,3,4,5";

        // then
        Assertions.assertThatThrownBy(() -> Utils.convertStringToIntegerList(numericString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자열을_리스트로_변환한다() {
        // given
        final String numericString = "1,2,3,4,5,6";

        // then
        Assertions.assertThatNoException()
                .isThrownBy(() -> Utils.convertStringToIntegerList(numericString));
    }
}