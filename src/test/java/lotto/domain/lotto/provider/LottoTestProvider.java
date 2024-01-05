package lotto.domain.lotto.provider;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.rank.Rank;
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

    public static Stream<Arguments> provideValuesForNumbersMatchedCountTest() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 20, 23, 24, 4), List.of(12, 1, 20, 2, 24, 3), 3),
                Arguments.of(List.of(1, 10, 15, 12, 2, 4), List.of(1, 10, 15, 12, 2, 4), 6),
                Arguments.of(List.of(11, 2, 23, 45, 6, 10), List.of(4, 1, 22, 44, 5, 3), 0)
        );
    }

    public static Stream<Arguments> provideValuesForCalculateRankTest() {
        return Stream.of(
                Arguments.of(
                        List.of(12, 13, 20, 23, 24, 4),
                        List.of(12, 13, 20, 1, 2, 3),
                        45, Rank.THREE_MATCHED
                ),
                Arguments.of(
                        List.of(12, 13, 20, 23, 24, 4),
                        List.of(12, 13, 20, 23, 1, 2),
                        45, Rank.FOUR_MATCHED
                ),
                Arguments.of(
                        List.of(12, 13, 20, 23, 24, 4),
                        List.of(12, 13, 20, 23, 24, 1),
                        45, Rank.FIVE_MATCHED
                ),
                Arguments.of(
                        List.of(12, 13, 20, 23, 24, 4),
                        List.of(12, 13, 20, 23, 24, 1),
                        4, Rank.FIVE_MATCHED_WITH_BONUS
                ),
                Arguments.of(
                        List.of(12, 13, 20, 23, 24, 4),
                        List.of(12, 13, 20, 23, 24, 4),
                        7, Rank.SIX_MATCHED
                ),
                Arguments.of(
                        List.of(12, 13, 20, 23, 24, 4),
                        List.of(45, 44, 43, 42, 41, 40),
                        39, null
                )
        );
    }
}
