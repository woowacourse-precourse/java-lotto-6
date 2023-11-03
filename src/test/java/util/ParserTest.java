package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    private final Parser parser = new Parser();

    @Test
    void 사용자_입력_값을_정수리스트로_변환() {
        List<Integer> expectedList = Arrays.asList(1, 3, 5, 7, 8);
        List<Integer> actualList = parser.parseWinningNumber("1,3,5,7,8");

        assertThat(actualList).containsExactlyInAnyOrderElementsOf(expectedList);
    }
}
