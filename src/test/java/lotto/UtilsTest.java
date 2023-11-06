package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UtilsTest {


    @DisplayName("문자열을 구분자로 분리해 숫자 리스트를 반환한다.")
    @ParameterizedTest
    @MethodSource("convertStringToIntegerListSuccessProvider")
    public void convertStringToIntegerListSuccessTest(String source, String delimiter, List<Integer> expected) {
        List<Integer> actual = Utils.convertStringToIntegerList(source, delimiter);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> convertStringToIntegerListSuccessProvider() {
        return Stream.of(
                Arguments.of("1,2,3", ",", List.of(1, 2, 3)),
                Arguments.of("1 2 3", " ", List.of(1, 2, 3)),
                Arguments.of("48, 132, 0235", ", ", List.of(45, 132, 235))
        );
    }



}
