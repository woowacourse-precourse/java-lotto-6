package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerInputsTest {
    @DisplayName("숫자가 아닌 문자가 하나라도 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",", "a", "a,1", "1,a", "1,a,2"})
    void createByNonInteger(String input) {
        assertThatThrownBy(() -> new IntegerInputs(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 입력을 쉼표로 구분해 Integer 리스트로 반환한다.")
    @ParameterizedTest
    @MethodSource("valuesArgumentsProvider")
    void values(String input, List<Integer> expectedValues) {
        IntegerInputs integerInputs = new IntegerInputs(input);

        assertThat(integerInputs.values()).containsExactlyInAnyOrderElementsOf(expectedValues);
    }

    static Stream<Arguments> valuesArgumentsProvider() {
        return Stream.of(
                Arguments.of("1", List.of(1)),
                Arguments.of("1,2", List.of(1, 2)),
                Arguments.of("1,2,3", List.of(1, 2, 3)),
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6))
        );
    }
}
