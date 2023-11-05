package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @DisplayName("숫자이면 true를 반환한다.")
    @Test
    void 숫자이면_True를_반환한다() {
        String s = "1234";

        assertThat(StringUtils.isDigit(s)).isTrue();
    }

    @DisplayName("숫자가 아니면 false를 반환한다.")
    @Test
    void 숫자가_아니면_False를_반환한다() {
        String s = "1234j";

        assertThat(StringUtils.isDigit(s)).isFalse();
    }
}
