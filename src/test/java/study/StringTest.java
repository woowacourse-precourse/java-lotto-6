package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
    @DisplayName("\"1,2\"을 ','로 split 했을 때 1과 2를 반환한다")
    @Test
    void split_outputTest1() {
        String given = "1,2";

        assertThat(given.split(","))
                .containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ','로 split 했을 때, 1만을 포함하는 배열이 반환한다.")
    @Test
    void split_outputTest2() {
        String given = "1";

        assertThat(given.split(","))
                .containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때, 괄호를 제거하고 \"1,2\"를 반환")
    @Test
    void substring_outputTest1() {
        String given = "(1,2)";

        assertThat(given.substring(1, 4))
                .isEqualTo("1,2");
    }

    @DisplayName("정상 범위의 인덱스를 입력하면 해당위치의 문자를 반환한다.")
    @ParameterizedTest(name = "\"abc\" 값이 주어졌을 때 {0}번째 글자로 {1}을/를 반환한다")
    @MethodSource
    void charAt_outputTest(int index, char character) {
        String given = "abc";
        assertThat(given.charAt(index))
                .isEqualTo(character);
    }

    static Stream<Arguments> charAt_outputTest() {
        return Stream.of(
                arguments(0, 'a'),
                arguments(1, 'b'),
                arguments(2, 'c')
        );
    }

    @DisplayName("정상 범위를 벗어난 인덱스를 입력하면 예외를 발생시킨다")
    @ParameterizedTest(name = "\"abc\" 값이 주어졌을 때 {0}번째 글자를 검색하면 StringIndexOutOfBoundsException를 발생시킨다")
    @ValueSource(ints = {-1, 3})
    void charAt_ExceptionTest(int index) {
        String given = "abc";

        assertThatThrownBy(() -> {
            given.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
