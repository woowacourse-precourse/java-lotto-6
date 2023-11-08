package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import lotto.utils.parser.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    @DisplayName("문자열을 기준대로 잘 자르는지 확인한다")
    void checkSplitString() {
        assertThat(StringParser.splitString("1,2,3,4,5,6")).contains("1","2","3","4","5","6");
    }

    @Test
    @DisplayName("문자열을 숫자 리스트로 변환하는지 확인한다")
    void checkParseStringToIntList() {
        assertThat(StringParser.parseStringToIntList("1,2,3,4,5,6"))
                .isInstanceOf(List.class)
                .contains(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("문자열을 숫자로 변환하는지 확인한다")
    void checkParseStringToInt() {
        assertThat(StringParser.parseStringToInt("10"))
                .isInstanceOf(Integer.class)
                .isEqualTo(10);
    }

    @Test
    @DisplayName("리스트를 셋으로 변환하는지 확인한다")
    void checkParseListToSet() {
        assertThat(StringParser.parseListToSet(List.of(1,2,3,4,5,5)))
                .isInstanceOf(Set.class)
                .contains(1,2,3,4,5);
    }
}