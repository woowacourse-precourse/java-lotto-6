package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,asdf", "qwer,12", "insfasd"})
    void stringToIntList_숫자가_아닌_문자일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Parser.stringToIntList("qwer,12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void stringToIntList_입력이_없을_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.stringToIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void stringToIntList_문자열을_Integer_List로_변환한다(String input, List<Integer> expected) {
        assertThat(Parser.stringToIntList(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "qwer12", "insfasd", "one"})
    void stringToInt_숫자가_아닌_문자일_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void stringToInt_입력이_없을_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "10,10", "20,20", "40,40"})
    void stringToIntList_문자열을_int로_변환한다(String input, int expected) {
        assertThat(Parser.stringToInt(input))
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("11,12,13,14,15,16", List.of(11, 12, 13, 14, 15, 16)),
                Arguments.of("21,22,23,24,25,26", List.of(21, 22, 23, 24, 25, 26)),
                Arguments.of("31,32,33,34,35,36", List.of(31, 32, 33, 34, 35, 36))
        );
    }
}
