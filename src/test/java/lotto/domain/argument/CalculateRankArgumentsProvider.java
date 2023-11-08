package lotto.domain.argument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Rank;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalculateRankArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6), 7, Rank.FIRST),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 7), 6, Rank.SECOND),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 7), 8, Rank.THIRD),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 7, 8), 9, Rank.FOURTH),
                Arguments.arguments(givenNumbers(1, 2, 3, 7, 8, 9), 10, Rank.FIFTH),
                Arguments.arguments(givenNumbers(1, 2, 7, 8, 9, 10), 11, Rank.NONE),
                Arguments.arguments(givenNumbers(1, 7, 8, 9, 10, 11), 12, Rank.NONE),
                Arguments.arguments(givenNumbers(7, 8, 9, 10, 11, 12), 13, Rank.NONE),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 7, 8), 5, Rank.FOURTH),
                Arguments.arguments(givenNumbers(1, 2, 3, 7, 8, 9), 4, Rank.FIFTH),
                Arguments.arguments(givenNumbers(1, 2, 7, 8, 9, 10), 3, Rank.NONE),
                Arguments.arguments(givenNumbers(1, 7, 8, 9, 10, 11), 2, Rank.NONE),
                Arguments.arguments(givenNumbers(7, 8, 9, 10, 11, 12), 1, Rank.NONE)
        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
