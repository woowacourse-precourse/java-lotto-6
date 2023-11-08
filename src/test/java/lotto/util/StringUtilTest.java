package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilTest {

    @Test
    @DisplayName("정수 리스트를 문자열 리스트로 변환")
    void toStringList() {
        List<Integer> integers = List.of(1, -2, 3, 0, 5, 45);

        List<String> converted = StringUtil.toStringList(integers);

        List<String> expected = List.of("1", "-2", "3", "0", "5", "45");
        assertThat(converted).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1,000", "999999:999,999", "-1111:-1,111", "0:0"}, delimiter = ':')
    @DisplayName("정수를 ,를 포함한 문자열로 변환")
    void toStringWithCommas(Integer input, String expected) {
        String converted = StringUtil.toStringWithCommas(input);

        assertThat(converted).isEqualTo(expected);
    }
}