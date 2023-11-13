package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 문자열_분리() {

        // given
        String[] separationOne;
        String[] separationTwo;

        // when
        separationOne = "1,2".split(",");
        separationTwo = "1".split(",");

        // then
        assertThat(separationOne)
                .containsExactly("1", "2");
        assertThat(separationTwo)
                .containsExactly("1");
    }

    @Test
    void 문자열_자르기() {

        // given
        String numbers = "(1,2)";

        // when
        numbers = numbers.substring(1, 4);

        // then
        assertThat(numbers).isEqualTo("1,2");
    }

    @DisplayName("charAt()사용과 인덱스 예외 처리")
    @Test
    void 특정_문자_가져오기() {

        // given
        String abc = "abc";

        // when, then
        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> abc.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
