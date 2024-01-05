package lotto.domain.winning.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class WinningNumbersTestProvider {

    public static Stream<Arguments> provideValuesForBonusNumberIsDuplicatedException() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 23, 24, 25, 4), 12),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(14, 1, 16, 17, 18, 45), 1)
        );
    }

    public static Stream<Arguments> provideValuesForBonusNumberIsOutOfRangeException() {
        return Stream.of(
                Arguments.of(List.of(12, 13, 23, 24, 25, 4), -1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 46),
                Arguments.of(List.of(14, 1, 16, 17, 18, 45), -100)
        );
    }
}
