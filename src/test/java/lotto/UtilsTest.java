package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {
    @DisplayName("숫자로 이루어진 문자열이 들어온 경우")
    @Test
    void normalNumberisNumericTest() {
        assertThat(Utils.isNumeric("1234500")).isEqualTo(true);
        assertThat(Utils.isNumeric("0001234")).isEqualTo(true);
    }
    @DisplayName("비어있는 문자열이 들어온 경우")
    @Test
    void emptyStringisNumericTest() {
        assertThat(Utils.isNumeric("")).isEqualTo(false);
    }
    @DisplayName("특수 문자가 포함된 문자열이 들어온 경우")
    @Test
    void normalNumberString() {
        assertThat(Utils.isNumeric("!1234")).isEqualTo(false);
        assertThat(Utils.isNumeric("12@34")).isEqualTo(false);
        assertThat(Utils.isNumeric("1234#")).isEqualTo(false);
    }
}