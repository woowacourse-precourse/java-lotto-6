package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UtilsTest {


    @DisplayName("문자열을 구분자로 분리한다.")
    @ParameterizedTest
    @MethodSource("splitByDelimiterProvider")
    public void splitByDelimiterTest(String source, String delimiter, List<String> expected) {
        List<String> actual = Utils.splitStringToList(source, delimiter);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> splitByDelimiterProvider() {
        return Stream.of(
                Arguments.of("1,2,3", ",", List.of("1", "2", "3")),
                Arguments.of("1 2 3", " ", List.of("1", "2", "3")),
                Arguments.of("1, 2 3", " ", List.of("1,", "2", "3"))
        );
    }

    @DisplayName("문자열을 구분자로 분리한다.")
    @ParameterizedTest
    @MethodSource("convertListStringToListIntegerProvider")
    public void convertListStringToListIntegerTest(List<String> source, List<Integer> expected) {
        List<Integer> actual = Utils.convertListStringToListInteger(source);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> convertListStringToListIntegerProvider() {
        return Stream.of(
                Arguments.of(List.of("1", "2", "3"), List.of(1, 2, 3)),
                Arguments.of(List.of("1", "2", "3", "4"), List.of(1, 2, 3, 4)),
                Arguments.of(List.of("1", "2", "3", "4", "5"), List.of(1, 2, 3, 4, 5))
        );
    }

}
