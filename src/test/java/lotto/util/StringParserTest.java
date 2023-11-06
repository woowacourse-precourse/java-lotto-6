package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


class StringParserTest {

    @DisplayName("문자열을 분리하는 테스트 : ,를 기준으로 문자열을 분리한다.")
    @Test
    void split() {
        String input = "1,2,3,4,5,6";

        List<Integer> result = StringParser.split(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}