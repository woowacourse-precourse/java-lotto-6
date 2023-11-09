package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("[요구사항1]  문자열을 ','로 분리")
    void splitString() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).contains("1", "2");

        result = "1".split(",");
        Assertions.assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("[요구사항2] '()'을 제거하고 문자열을 반환")
    void substringString() {
        String result = "(1,2)".substring(1, "(1,2)".length() - 1);
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("[요구사항3] 특정 위치의 문자 가져오기 - StringIndexOutOfBoundsException")
    void charAtStringWithException() {
        // 요구사항 3-2, assertThatThrownBy 사용
        Assertions.assertThatThrownBy(() -> {
                    "abc".charAt(3);
                }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        // 요구사항 3-2, assertThatExceptionOfType 사용
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
