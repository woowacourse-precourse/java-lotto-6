package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class LottoNumberSizeNotMatchArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers()),
                Arguments.arguments(givenNumbers(1)),
                Arguments.arguments(givenNumbers(1, 2)),
                Arguments.arguments(givenNumbers(1, 2, 3)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
