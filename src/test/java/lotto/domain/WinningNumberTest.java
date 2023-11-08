package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {

    private static final String errorPrefix = "[ERROR] ";

    private static Stream<List<Integer>> provideValidIntArray() {

        return Stream.of(
                List.of(1, 2, 45, 3, 4, 5),
                List.of(20, 21, 22, 40, 41, 42)
        );
    }

    private static Stream<List<Integer>> provideInvalidIntArray() {
        return Stream.of(
                List.of(1, 2, 50, 4, 1),
                List.of(1, 2, 50, 2),
                List.of(-1, -1),
                List.of(1, 2, 3, 4, 100, 200, 300, 1)
        );
    }

    @ParameterizedTest
    @DisplayName("WinningNumber: 적절한 입력이 주어졌을 때 객체 생성에 성공한다")
    @MethodSource("provideValidIntArray")
    void WinningNumber_정상_입력(List<Integer> value) {

        WinningNumber winningNumber = new WinningNumber(value);

        assertThat(winningNumber.getNumbers()).isEqualTo(value);
    }

    @ParameterizedTest
    @DisplayName("WinningNumber: 잘못된 입력이 주어졌을 때 예외가 발생한다")
    @MethodSource("provideInvalidIntArray")
    void WinningNumber_잘못된_입력(List<Integer> value) {

        assertThatThrownBy(() -> new WinningNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorPrefix);
    }

}