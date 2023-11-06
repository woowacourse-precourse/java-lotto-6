package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {
    @DisplayName("문자열을 구분자를 기준으로 리스트로 파싱한다.")
    @Test
    void parseInputByDelimiter() {
        String input = "asd,123,zxc,asd2,124";
        List<String> expectedValue = Arrays.asList("asd", "123", "zxc", "asd2", "124");
        assertThat(InputParser.splitByDelimiter(input)).isEqualTo(expectedValue);
    }
}
