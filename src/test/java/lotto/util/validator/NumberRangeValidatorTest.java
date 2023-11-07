package lotto.util.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberRangeValidatorTest {
    @Test
    void 범위_밖의_숫자이다() {
        Assertions.assertThat(NumberRangeValidator.isInvalidRange(46)).isTrue();
    }

    @Test
    void 범위_밖의_숫자가_아니다() {
        Assertions.assertThat(NumberRangeValidator.isInvalidRange(4)).isFalse();
    }
}