package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.Parser;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    public void Parser_테스트() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        List<String> result = Parser.parseWithComma(numbers);

        // then
        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6");
    }
}
