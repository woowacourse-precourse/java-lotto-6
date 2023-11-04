package lotto.domain;

import lotto.domain.Lotto;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("로또")
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    @ParameterizedTest
    @MethodSource("numbersOverSizeDummy")
    void createLottoByOverSizeTest(List<Integer> numbersOverSize) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbersOverSize));

    }

    @DisplayName("로또 번호의 개수가 6개 보다 적으면 예외 발생")
    @ParameterizedTest
    @MethodSource("numbersSmallSizeDummy")
    void createLottoBySmallSizeTest(List<Integer> numbersSmallSize) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbersSmallSize));

    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @ParameterizedTest
    @MethodSource("duplicatedNumbersDummy")
    void createLottoByDuplicatedNumbersTest(List<Integer> duplicatedNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(duplicatedNumbers));
    }

    static Stream<Arguments> numbersOverSizeDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    static Stream<Arguments> numbersSmallSizeDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1)),
                Arguments.arguments(List.of(1, 2)),
                Arguments.arguments(List.of(1, 2, 3))
        );
    }

    static Stream<Arguments> duplicatedNumbersDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1, 2, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1, 2, 3, 3, 4, 5))
        );
    }


}