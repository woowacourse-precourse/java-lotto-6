package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class StringUtilTest {

    @Test
    @DisplayName("문자열을 정수 리스트로 변환하는지 테스트")
    void splitAndParse() {
        String input = "1, 2, 3, 4, 5";
        String delimiter = ", ";

        List<Integer> result = StringUtil.splitAndParse(input, delimiter);

        assertEquals(5, result.size());
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("다른 구분자를 사용하여 정수 리스트로 변환하는지 테스트")
    void splitAndParseWithDifferentDelimiter() {
        String input = "1|2|3|4|5";
        String delimiter = "\\|";

        List<Integer> result = StringUtil.splitAndParse(input, delimiter);

        assertEquals(5, result.size());
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("공백을 포함한 문자열을 정수 리스트로 변환하는지 테스트")
    void splitAndParseWithSpaceInInput() {
        String input = "1, 2, 3, 4, 5";
        String delimiter = ", ";

        List<Integer> result = StringUtil.splitAndParse(input, delimiter);

        assertEquals(5, result.size());
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("특정 값을 포함하는지 테스트")
    void splitAndParseContainsSpecificValue() {
        String input = "1, 2, 3, 4, 5";
        String delimiter = ", ";

        List<Integer> result = StringUtil.splitAndParse(input, delimiter);

        assertThat(result).contains(3);
    }

    @Test
    @DisplayName("유효하지 않은 입력에 대한 예외 처리 테스트")
    void splitAndParseWithInvalidInput() {
        String input = "1, 2, 3, abc, 5";
        String delimiter = ", ";

        assertThrows(NumberFormatException.class, () -> {
            StringUtil.splitAndParse(input, delimiter);
        });
    }
}
