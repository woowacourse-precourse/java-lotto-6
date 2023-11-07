package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
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

    @ParameterizedTest
    @MethodSource("invalidSize")
    @DisplayName("로또 개수 실패 테스트")
    void invalidSizeTest(List<Integer> invalidRange) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(invalidRange));
    }

    static Stream<Arguments> invalidSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(39, 40, 41, 42, 43, 44, 45)),
                Arguments.of(List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("validSize")
    @DisplayName("로또 개수 성공 테스트")
    void validSizeTest(List<Integer> validSize) {
        assertDoesNotThrow(
                () -> new Lotto(validSize));
    }

    static Stream<Arguments> validSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidRange")
    @DisplayName("로또 범위 실패 테스트")
    void invalidRangeTest(List<Integer> invalidRange) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(invalidRange));
    }

    static Stream<Arguments> invalidRange() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(-1, 0, 1, 46, 47, 48))
        );
    }

    @ParameterizedTest
    @MethodSource("validRange")
    @DisplayName("로또 범위 성공 테스트")
    void validRangeTest(List<Integer> validRange) {
        assertDoesNotThrow(
                () -> new Lotto(validRange));
    }

    static Stream<Arguments> validRange() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateNumber")
    @DisplayName("중복된 번호 테스트")
    void duplicateNumberTest(List<Integer> duplicateNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(duplicateNumber));
    }

    static Stream<Arguments> duplicateNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("uniqueNumber")
    @DisplayName("중복되지 않은 번호 테스트")
    void uniqueNumberTest(List<Integer> uniqueNumber) {
        assertDoesNotThrow(
                () -> new Lotto(uniqueNumber));
    }

    static Stream<Arguments> uniqueNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45))
        );
    }
}