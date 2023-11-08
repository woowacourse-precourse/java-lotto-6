package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";

        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring_메서드로_주어진_괄호를_제거한다() {
        String input = "(1,2)";

        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("charAt 메서드 테스트")
    class CharAtTest {

        @Test
        @DisplayName("charAt 메서드로 특정 위치의 문자 찾기")
        void success() {
            String input = "abc";

            char charAtElement = input.charAt(0);

            assertThat(charAtElement).isEqualTo('a');
        }

        @Test
        @DisplayName("charAt 메서드 사용시 문자열의 길이보다 큰 숫자 위치의 문자를 찾을 때 예외 발생")
        void fail() {
            String input = "abc";

            assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
        }
    }
}
