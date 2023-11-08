package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.Parser.parseWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    private static Stream<Arguments> normalParseWinningNumbersArguments() {
        return Stream.of(
                Arguments.arguments("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments("34,32,25,41,2,4", List.of(34, 32, 25, 41, 2, 4)),
                Arguments.arguments("18,34,28,42,3,8", List.of(18, 34, 28, 42, 3, 8))
        );
    }

    private static Stream<Arguments> exceptionParseWinningNumbersArguments() {
        return Stream.of(
                Arguments.arguments("알파벳이 포함된 경우", "hello"),
                Arguments.arguments("공백이 포함된 경우", " , , , , , "),
                Arguments.arguments("기호가 포함된 경우", "!,@,#,1,2,3")
        );
    }

    @ParameterizedTest(name = "입력 : {0}")
    @MethodSource("normalParseWinningNumbersArguments")
    @DisplayName("정상적인 당첨 번호 파서 테스트")
    void normalParseWinningNumbersTest(String winningNumbers, List<Integer> splitWinningNumbers) {
        assertThat(parseWinningNumbers(winningNumbers))
                .isEqualTo(splitWinningNumbers);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("exceptionParseWinningNumbersArguments")
    @DisplayName("예외적인 당첨 번호 파서 테스트")
    void exceptionParseWinningNumbersTest(String testName, String winningNumbers) {
        assertThatThrownBy(() -> parseWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
