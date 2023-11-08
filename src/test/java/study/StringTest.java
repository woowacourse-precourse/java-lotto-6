package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
    @DisplayName("쉼표가 포함된 문자열을 split 메소드를 사용하여 잘 분리되는지 확인한다.")
    @Test
    void splitStringWithComma() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("쉼표가 포함되지 않은 문자열(길이 1)를 split 메소드를 사용해도 문자열만 반환하는지 확인한다.")
    @Test
    void splitStringWithoutComma() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("소괄호가 포함된 문자열을 substring 메소드를 활용하여 소괄호를 제거하고 문자열을 반환하는지 확인한다.")
    @Test
    void substringStringWithRoundBrackets() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열에서 charAt 메소드를 활용해 특정 위치의 문자를 가져오는지 확인한다.")
    @Test
    void charAtString() {
        String input = "abc";
        char result = input.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @DisplayName("문자열에서 charAt 메소드를 활용해 문자열에서 벗어난 문자를 가져올 때 예외가 발생하는지 확인한다.")
    @Test
    void throwExceptionByCharAtString() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageContaining("String index out of range: 3");
    }
}
