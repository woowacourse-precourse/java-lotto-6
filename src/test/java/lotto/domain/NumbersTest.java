package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {
    private static final String DUPLICATION_EXIST = "[ERROR] 로또 번호에는 중복되는 숫자가 없어야 합니다.";

    private static Stream<Arguments> provideListForDuplicatedSource() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5))
        );
    }

    private static Stream<Arguments> provideListForNotDuplicatedSource() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 10, 20, 30, 40, 45))
        );
    }

    @DisplayName("숫자에 중복된 값이 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideListForDuplicatedSource")
    void createNumbersByDuplicatedSource(List<Integer> numbersValue) {
        assertThatThrownBy(
                () -> Numbers.from(numbersValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_EXIST);
    }

    @DisplayName("숫자에 중복된 값이 없으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideListForNotDuplicatedSource")
    void createNumbersByNotDuplicatedSource(List<Integer> numbersValue) {
        assertThatCode(
                () -> Numbers.from(numbersValue))
                .doesNotThrowAnyException();
    }
}