package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoInputParserTest {

    private final LottoInputParser lottoInputParser = new LottoInputParser();

    @DisplayName("유효한 숫자 리스트 문자열이라면 파싱해야 한다.")
    @ParameterizedTest(name = "[{index}] 입력: ''{0}'', 결과: ''{1}''")
    @CsvSource({
            "'1,2,3,4,5,6', '1,2,3,4,5,6'",
            "'10, 20, 30, 40, 50', '10,20,30,40,50'",
            "'15,   25  ,   35  ', '15,25,35'"
    })
    void parseIntegerList_ValidInput_ShouldReturnListOfIntegers(String input, String expected) {
        List<Integer> expectedNumbers = Arrays.stream(expected.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        assertThat(lottoInputParser.parseIntegerList(input)).containsExactlyElementsOf(expectedNumbers);
    }

    @DisplayName("유효하지 않은 숫자 리스트 문자열에 대해 예외를 던져야 한다")
    @ParameterizedTest(name = "[{index}] 입력: ''{0}''")
    @ValueSource(strings = {"", " ", ",", "   ,    ", "a,b,c", "1, 2, , 4", "1, 2, 3, 4, 5, 5.5"})
    void parseIntegerList_InvalidInput_ShouldThrowException(String input) {
        assertThatThrownBy(() -> lottoInputParser.parseIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 단일 숫자 문자열을 파싱해야 한다")
    @ParameterizedTest(name = "[{index}] 입력: ''{0}'', 결과: {1}")
    @CsvSource({
            "0, 0",
            "42, 42",
            " 100, 100"
    })
    void parseInt_ValidInput_ShouldReturnInteger(String input, int expected) {
        assertThat(lottoInputParser.parseInt(input)).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 단일 숫자 문자열에 대해 예외를 던져야 한다")
    @ParameterizedTest(name = "[{index}] 입력: ''{0}''")
    @ValueSource(strings = {"", " ", "abc", "123a", "5.5", "10,000", "10_000"})
    void parseInt_InvalidInput_ShouldThrowException(String input) {
        assertThatThrownBy(() -> lottoInputParser.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
