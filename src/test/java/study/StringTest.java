package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split() 메서드 사용 테스트")
    void splitStringTest() {
        String string1 = "1,2";
        String string2 = "1";

        String[] result1 = string1.split(",");
        String[] result2 = string2.split(",");

        assertThat(result1).contains("2", "1");
        assertThat(result2).contains("1");
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("subString() 메서드 사용 테스트")
    void subStringTest() {
        String string1 = "(1,2)";

        String result = string1.substring(0, string1.length() - 1);

        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("문자열의 범위를 넘어선 인덱스 위치 접근 시 예외 발생 테스트")
    void charAtTest() {
        String string1 = "abc";

        assertThatThrownBy(() -> string1.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
