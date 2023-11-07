package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    @DisplayName("올바르지 않은 입력이 주어질때 예외 메시지에 [ERROR]가 포함 된 예외가 발생한다")
    @Test
    void testParseIntThrow() {
        assertThatThrownBy(() -> StringUtils.parseInt("일"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("공백 문자가 구분자 사이에 있을때 에러 메시지에 [ERROR]가 포함 된 예외가 발생한다")
    @Test
    void testParseIntListThrow() {
        assertThatThrownBy(() -> StringUtils.parseIntList(",1,2,3", ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> StringUtils.parseIntList("1,,1,2,3", ","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
