package lotto.domain.argument;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.Rank;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalculateTotalRankCountArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 45), 7,
                        Map.of(Rank.FIFTH, 0, Rank.FOURTH, 0, Rank.THIRD, 0, Rank.SECOND, 0, Rank.FIRST, 1)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 23), 45,
                        Map.of(Rank.FIFTH, 0, Rank.FOURTH, 0, Rank.THIRD, 0, Rank.SECOND, 1, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 23), 24,
                        Map.of(Rank.FIFTH, 0, Rank.FOURTH, 0, Rank.THIRD, 1, Rank.SECOND, 0, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 15, 17), 18,
                        Map.of(Rank.FIFTH, 0, Rank.FOURTH, 1, Rank.THIRD, 0, Rank.SECOND, 0, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6), 7,
                        Map.of(Rank.FIFTH, 1, Rank.FOURTH, 0, Rank.THIRD, 0, Rank.SECOND, 0, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 15, 16), 17,
                        Map.of(Rank.FIFTH, 1, Rank.FOURTH, 1, Rank.THIRD, 0, Rank.SECOND, 0, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 16, 32), 33,
                        Map.of(Rank.FIFTH, 0, Rank.FOURTH, 2, Rank.THIRD, 0, Rank.SECOND, 0, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 11, 14, 22), 24,
                        Map.of(Rank.FIFTH, 1, Rank.FOURTH, 0, Rank.THIRD, 1, Rank.SECOND, 0, Rank.FIRST, 0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 11, 14, 22), 45,
                        Map.of(Rank.FIFTH, 1, Rank.FOURTH, 0, Rank.THIRD, 0, Rank.SECOND, 1, Rank.FIRST, 0))

        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
