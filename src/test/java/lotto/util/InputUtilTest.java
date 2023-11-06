package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilTest {

    @Test
    @DisplayName("입력 값 int 형으로 convert 성공 케이스")
    void INT_CONVERT_성공() {
        assertThatCode(() -> InputUtil.convert("123"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력 값 int 형으로 convert 실패 케이스")
    void INT_CONVERT_실패() {
        assertThatThrownBy(() -> InputUtil.convert("123마"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}