package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class StringTest {
    @DisplayName("'1,2'를 split 하면 [1,2]이 된다.")
    @Test
    void createStringArrayBySplit() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("1", "2");
    }

    @DisplayName("'1'를 split 하면 [1]이 된다.")
    @Test
    void createStringBySplit() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @DisplayName("'(1,2)'의 괄호를 substring 하면 '1,2'가 된다.")
    @Test
    void createStringBySubString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("'abc'에 charAt을 하면 특정 문자를 가져온다.")
    @Test
    void createStringByCharAt() {
        String input = "abc";
        Character result = input.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @DisplayName("'abc'에 charAt을 하면 특정 문자를 가져온다.")
    @Test
    void createStringByCharAtButOutOfRange() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
