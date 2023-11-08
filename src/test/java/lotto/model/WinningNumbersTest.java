package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningNumbersTest {
    private static Stream<Arguments> normalWinningNumbersArguments() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(List.of(45, 23, 42, 17, 35, 31)),
                Arguments.arguments(List.of(35, 1, 45, 32, 12, 22))
        );
    }

    private static Stream<Arguments> exceptionWinningNumbersArguments() {
        return Stream.of(
                Arguments.arguments("0이 포함된 경우", List.of(0, 2, 3, 4, 5, 8)),
                Arguments.arguments("음수가 포함된 경우", List.of(-1, 3, 23, 34, 15, 21)),
                Arguments.arguments("45보다 큰 수가 포함된 경우", List.of(46, 23, 29, 36, 21, 45)),
                Arguments.arguments("중복된 수가 포함된 경우", List.of(2, 3, 2, 5, 23, 5)),
                Arguments.arguments("6개보다 많은 수가 포함된 경우", List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest(name = "당첨 숫자 : {0}")
    @MethodSource("normalWinningNumbersArguments")
    @DisplayName("정상적인 당첨 숫자 테스트")
    void normalWinningNumbersTest(List<Integer> winningNumbers) {
        // when, then
        assertDoesNotThrow(() -> new WinningNumbers(winningNumbers));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("exceptionWinningNumbersArguments")
    @DisplayName("예외적인 당첨 숫자 테스트")
    void exceptionWinningNumbersTest(String testName, List<Integer> winningNumbers) {
        // when, then
        assertThatThrownBy(() -> new WinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
