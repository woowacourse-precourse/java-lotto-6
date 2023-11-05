package lotto.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    @ParameterizedTest
    @MethodSource("invalidSize")
    @DisplayName("로또 개수 실패 테스트")
    void invalidSizeTest(List<Integer> invalidRange) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(invalidRange));
    }

    static Stream<Arguments> invalidSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5)),
                Arguments.of(Arrays.asList(39,40,41,42,43,44,45)),
                Arguments.of(List.of())
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
                Arguments.of(Arrays.asList(0,1,2,3,4,5)),
                Arguments.of(Arrays.asList(-1,0,1,46,47,48))
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
                Arguments.of(Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(Arrays.asList(40,41,42,43,44,45))
        );
    }
}
