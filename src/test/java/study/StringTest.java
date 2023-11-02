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
}
