package lotto.domain.lotto.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LottoTestProvider {

    public static Stream<Arguments> provideValuesForNumbersOutOfSizeExceptionTest() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 23, 23, 34, 4, 2)),
                Arguments.of(List.of(1, 12, 12, 12, 2, 4, 1)),
                Arguments.of(List.of(5, 2, 23, 45, 2, 45, 10))
        );
    }

    public static Stream<Arguments> provideValuesForNumbersOutOfRangeExceptionTest() {
        return Stream.of(
                Arguments.of(List.of(0, 13, 23, 23, 23, 46)),
                Arguments.of(List.of(1, 48, 12, 12, 2, 4)),
                Arguments.of(List.of(5, 2, 23, 45, 2, -29))
        );
    }

    public static Stream<Arguments> provideValuesForNumbersDuplicatedExceptionTest() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 23, 23, 23, 4)),
                Arguments.of(List.of(1, 12, 12, 12, 2, 4)),
                Arguments.of(List.of(5, 2, 23, 45, 2, 45))
        );
    }

    public static Stream<Arguments> provideValuesForNumbersContainsTargetNumberTrueTest() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 20, 23, 24, 4), 20),
                Arguments.of(List.of(1, 10, 15, 12, 2, 4), 10),
                Arguments.of(List.of(5, 2, 23, 45, 6, 4), 5)
        );
    }

    public static Stream<Arguments> provideValuesForNumbersContainsTargetNumberFalseTest() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 20, 23, 24, 4), 21),
                Arguments.of(List.of(1, 10, 15, 12, 2, 4), 19),
                Arguments.of(List.of(5, 2, 23, 45, 6, 4), 40)
        );
    }
}
