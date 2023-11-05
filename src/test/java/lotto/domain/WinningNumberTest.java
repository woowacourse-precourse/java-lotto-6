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

    @Nested
    @DisplayName("당첨 번호 검증 테스트")
    class ValidationTest {

        private static final String SIZE_EXCEPTION_MESSAGE = "당첨 번호는 6자리이어야 합니다";
        private static final String OVERLAPPED_EXCEPTION_MESSAGE = "당첨 번호, 보너스 번호는 서로 겹쳐서는 안됩니다";

        @Test
        @DisplayName("당첨 번호가 6자리가 아니라면, 예외를 던진다")
        void validationTest_whenWinningNumbersSizeIsNot6_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6, 7));
            Number bonusNumber = Number.from(10);

            assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(SIZE_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호에 중복되는 숫자가 있다면, 예외를 던진다")
        void validationTest_whenWinningNumbersIsOverlapped_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 2));
            Number bonusNumber = Number.from(10);

            assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(OVERLAPPED_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("보너스 번호가 당첨 번호와 중복된다면, 예외를 던진다")
        void validationTest_whenBonusNumberIsOverlappedByWinningNumber_throwException() {
            List<Number> winningNumbers = toNumberList(List.of(1, 2, 3, 4, 5, 6));
            Number bonusNumber = Number.from(4);

            assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(OVERLAPPED_EXCEPTION_MESSAGE);
        }
    }
    
    List<Number> toNumberList(List<Integer> values) {
        return values.stream().map(Number::from).toList();
    }
}