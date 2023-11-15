package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("주어진 값에 대한 분리 테스트")
    @Test
    void split_Test() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @DisplayName("주어진 값에 대한 특정 문자열 추출 테스트")
    @Test
    void substring_Test() {
        String value = "(1,2)";
        String result = value.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("주어진 값에 대한 특정 위치의 문자 추출 테스트")
    @Test
    void charAt_Test() {
        String value = "abc";
        char result = value.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @DisplayName("주어진 값에 대해 특정 위치의 문자열 추출 시 벗어난 범위에 대한 예외처리 테스트")
    @Test
    void Exception_rangeOfChartAt_Test() {
        String value = "abc";

        assertThatThrownBy(() -> value.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
