package lotto.domain.argument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class LottoCompareArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 7), 5),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 7, 8), 4),
                Arguments.arguments(givenNumbers(1, 2, 3, 7, 8, 9), 3),
                Arguments.arguments(givenNumbers(1, 2, 7, 8, 9, 10), 2),
                Arguments.arguments(givenNumbers(1, 7, 8, 9, 10, 11), 1),
                Arguments.arguments(givenNumbers(7, 8, 9, 10, 11, 12), 0)
        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
