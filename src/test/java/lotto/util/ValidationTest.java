package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

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
    @DisplayName("isNumericValue: 숫자 형식의 String이 주어지면 true를 반환한다")
    @ValueSource(strings = {"1", "123", "-123", "-12345"})
    void isNumericValue_true(String value) {

        assertThat(Validation.isNumericValue(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("isNumericValue: 숫자 형식이 아닌 String이 주어지면 false를 반환한다")
    @ValueSource(strings = {"a", "1a2", "test", "-"})
    @NullAndEmptySource
    void isNumericValue_false(String value) {

        assertThat(Validation.isNumericValue(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("hasCorrectRange: 1 이상 45 이하의 수에 대해 true를 반환한다")
    @ValueSource(ints = {1, 10, 45})
    void hasCorrectRange_true(int value) {

        assertThat(Validation.hasCorrectRange(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("hasCorrectRange: 1 미만 또는 45 초과의 수에 대해 false를 반환한다")
    @ValueSource(ints = {-10, 0, 46, 50, 1000})
    void hasCorrectRange_false(int value) {

        assertThat(Validation.hasCorrectRange(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("배열_hasCorrectRange: 1 이상 45 이하 정수들의 리스트가 주어졌을 때 true를 반환한다")
    @MethodSource("provideValidIntArray")
    void 배열_hasCorrectRange_true(List<Integer> value) {

        assertThat(Validation.hasCorrectRange(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("배열_hasCorrectRange: 1 미만 또는 45 초과 정수들의 리스트가 주어졌을 때 false를 반환한다")
    @MethodSource("provideInvalidIntArray")
    void 배열_hasCorrectRange_false(List<Integer> value) {

        assertThat(Validation.hasCorrectRange(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("hasCorrectSize: 크기가 6인 배열이 주어졌을 때 true 를 반환한다")
    @MethodSource("provideValidIntArray")
    void hasCorrectSize_true(List<Integer> value) {

        assertThat(Validation.hasCorrectSize(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("hasCorrectSize: 크기가 6이 아닌 배열이 주어졌을 때 false 를 반환한다")
    @MethodSource("provideInvalidIntArray")
    void hasCorrectSize_false(List<Integer> value) {

        assertThat(Validation.hasCorrectSize(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("isPositive: 양수가 주어졌을 때 true 를 반환한다")
    @ValueSource(ints = {1, 2, 3, 4})
    void isPositive_true(int value) {

        assertThat(Validation.isPositive(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("isPositive: 양수가 아닌 수가 주어졌을 때 false 를 반환한다")
    @ValueSource(ints = {0, -1, -100})
    void isPositive_false(int value) {

        assertThat(Validation.isPositive(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("hasDuplicate: 중복이 없는 리스트가 주어졌을 때 false 를 반환한다")
    @MethodSource("provideValidIntArray")
    void hasDuplicate_false(List<Integer> value) {

        assertThat(Validation.hasDuplicate(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("hasDuplicate: 중복이 있는 리스트가 주어졌을 때 true 를 반환한다")
    @MethodSource("provideInvalidIntArray")
    void hasDuplicate_true(List<Integer> value) {

        assertThat(Validation.hasDuplicate(value)).isTrue();
    }
}