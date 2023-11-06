package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class LottoNumberRangeNotMatchArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers(-1, 2, 3, 4, 5, 6)),
                Arguments.arguments(givenNumbers(0, 2, 3, 4, 5, 6)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 46)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 47)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 48)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 100)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 1000))
        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
