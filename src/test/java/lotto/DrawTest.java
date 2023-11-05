package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrawTest {

    @Test
    void 문자열_분리_테스트() {

        //given
        String input = "1,2,3";

        //when
        String[] result = input.split(",");

        //then
        Assertions.assertThat(result).containsExactly("1", "2", "3");
    }
}
