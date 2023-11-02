package study;

import static org.assertj.core.api.Assertions.assertThat;

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
        numbers = numbers.substring(1,4);

        // then
        assertThat(numbers).isEqualTo("1,2");
    }
}
