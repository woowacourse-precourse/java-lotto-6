package lotto.domain.argument;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalculateTotalWinningPriceArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 45), 7, BigDecimal.valueOf(2_000_000_000)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 23), 45, BigDecimal.valueOf(30_000_000)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 23), 24, BigDecimal.valueOf(1_500_000)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 15, 17), 18, BigDecimal.valueOf(50_000)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6), 7, BigDecimal.valueOf(5_000)),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 7, 8), 9, BigDecimal.valueOf(0)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 15, 16), 17, BigDecimal.valueOf(55_000)),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 16, 32), 33, BigDecimal.valueOf(100_000)),
                Arguments.arguments(givenNumbers(1, 3, 5, 11, 14, 22), 24, BigDecimal.valueOf(1_505_000)),
                Arguments.arguments(givenNumbers(1, 3, 5, 11, 14, 22), 45, BigDecimal.valueOf(30_005_000))

        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
