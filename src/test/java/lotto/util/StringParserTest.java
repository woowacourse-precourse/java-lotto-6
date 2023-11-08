package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 나누기 테스트")
class StringParserTest {
    @DisplayName("쉼표를 기반으로 문자열을 나눈다.")
    @Test
    void testTokenize() {
        String input = "1,2,3,4,5,6";
        List<String> tokenized = StringParser.parseToList(input);
        Assertions.assertThat(tokenized).containsExactly("1", "2", "3", "4", "5", "6");
    }
}