package lotto;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {
    @DisplayName("숫자로 이루어진 문자열이 들어올 때 true 반환한다.")
    @Test
    void normalNumberisNumericTest() {
        assertThat(Utils.isNumeric("1234500")).isEqualTo(true);
        assertThat(Utils.isNumeric("0001234")).isEqualTo(true);
    }
    @DisplayName("비어있는 문자열이 들어온 경우 false 반환한다.")
    @Test
    void emptyStringisNumericTest() {
        assertThat(Utils.isNumeric("")).isEqualTo(false);
    }
    @DisplayName("특수 문자가 포함된 문자열이 들어온 경우 false를 반환한다.")
    @Test
    void specialWordStringisNumericTest() {
        assertThat(Utils.isNumeric("!1234")).isEqualTo(false);
        assertThat(Utils.isNumeric("12@34")).isEqualTo(false);
        assertThat(Utils.isNumeric("1234#")).isEqualTo(false);
    }

    @DisplayName("제외 문자가 포함되었을 때 해당 문자는 제외하고 검증을 진행한다.")
    @Test
    void normalNumberStringWithExcludeWord() {
        assertThat(Utils.isNumeric("12,34,56", List.of(","))).isEqualTo(true);
        assertThat(Utils.isNumeric("1!2@3#", Arrays.asList("!", "@", "#"))).isEqualTo(true);
    }
    @DisplayName("제외 문자가 비어 있을 때 기존과 똑같이 검증을 진행한다.")
    @Test
    void normalNumberStringWithEmptyExcludeWord() {
        assertThat(Utils.isNumeric("123", List.of())).isEqualTo(true);
        assertThat(Utils.isNumeric("12,34,56", List.of())).isEqualTo(false);
    }
}