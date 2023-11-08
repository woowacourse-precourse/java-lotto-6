package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {

    private static final String SIZE_EXCEPTION_MESSAGE = "당첨 번호는 6자리이어야 합니다";

    @Nested
    @DisplayName("당첨 번호 단독 덤증 테스트")
    class ValidatingWinningNumbersTest {
        private static final String OVERLAPPED_EXCEPTION_MESSAGE = "당첨 번호는 서로 겹쳐서는 안됩니다";

        @Test
        @DisplayName("당첨 번호가 6자리가 아니라면, 예외를 던진다")
        void validateTest_whenWinningNumbersSizeIsNot6_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6, 7));

            assertThatThrownBy(() -> WinningNumber.validate(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(SIZE_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호에 중복되는 숫자가 있다면, 예외를 던진다")
        void validateTest_whenWinningNumbersIsOverlapped_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 2));

            assertThatThrownBy(() -> WinningNumber.validate(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(OVERLAPPED_EXCEPTION_MESSAGE);
        }
    }

    @Nested
    @DisplayName("당첨 번호 생성 검증 테스트")
    class ValidatingCreationTest {

        private static final String OVERLAPPED_EXCEPTION_MESSAGE = "당첨 번호, 보너스 번호는 서로 겹쳐서는 안됩니다";

        @Test
        @DisplayName("당첨 번호가 6자리가 아니라면, 예외를 던진다")
        void createTest_whenWinningNumbersSizeIsNot6_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6, 7));
            Number bonusNumber = Number.from(10);

            assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(SIZE_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호에 중복되는 숫자가 있다면, 예외를 던진다")
        void createTest_whenWinningNumbersIsOverlapped_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 2));
            Number bonusNumber = Number.from(10);

            assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(OVERLAPPED_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("보너스 번호가 당첨 번호와 중복된다면, 예외를 던진다")
        void createTest_whenBonusNumberIsOverlappedByWinningNumber_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6));
            Number bonusNumber = Number.from(4);

            assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(OVERLAPPED_EXCEPTION_MESSAGE);
        }
    }

    @ParameterizedTest(name = "당첨 번호와 맞은 개수 {1}")
    @MethodSource
    @DisplayName("당첨 번호와 맞은 개수를 셀 수 있다")
    void countMatchingWinningNumberTest(List<Integer> values, int expected) {
        List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6));
        Number bonusNumber = Number.from(7);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        List<Number> numbers = toNumberList(values);

        int actual = winningNumber.countMatchingWinningNumber(numbers);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> countMatchingWinningNumberTest() {
        return Stream.of(
                arguments(List.of(7, 8, 9, 10, 11, 12), 0),
                arguments(List.of(7, 8, 9, 3, 11, 12), 1),
                arguments(List.of(7, 8, 9, 3, 11, 1), 2),
                arguments(List.of(4, 8, 9, 3, 11, 1), 3),
                arguments(List.of(3, 4, 5, 6, 2, 1), 6));
    }

    @ParameterizedTest(name = "보너스 번호 일치 : {1}")
    @CsvSource({"7,true", "13,false"})
    @DisplayName("보너스 번호와 맞았는지 알 수 있다")
    void isMatchingBonusNumberTest(int bonusValue, boolean expected) {
        List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6));
        Number bonusNumber = Number.from(bonusValue);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        List<Number> numbers = toNumberList(List.of(7, 8, 9, 10, 11, 12));

        boolean actual = winningNumber.isMatchingBonusNumber(numbers);

        assertThat(actual).isEqualTo(expected);
    }

    List<Number> toNumberList(List<Integer> values) {
        return values.stream().map(Number::from).toList();
    }
}
