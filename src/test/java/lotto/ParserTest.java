package lotto;

import lotto.domain.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {
    @DisplayName("문자열을 올바르게 파싱하는지 테스트")
    @Test
    void testParseNumbers() {
        String input = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> parsedNumbers = Parser.parseNumbers(input);
        assertThat(parsedNumbers).isEqualTo(expectedNumbers);
    }
}
