package lotto.domain.argument;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalculateProfitArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 45), 7, new BigDecimal("25000000.0")),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 23), 45, new BigDecimal("375000.0")),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 22, 23), 24, new BigDecimal("18750.0")),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 15, 17), 18, new BigDecimal("625.0")),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6), 7, new BigDecimal("62.5")),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 15, 16), 17, new BigDecimal("687.5")),
                Arguments.arguments(givenNumbers(1, 3, 5, 14, 16, 32), 33, new BigDecimal("1250.0")),
                Arguments.arguments(givenNumbers(1, 3, 5, 11, 14, 22), 24, new BigDecimal("18812.5")),
                Arguments.arguments(givenNumbers(1, 3, 5, 11, 14, 22), 45, new BigDecimal("375062.5"))

        );
    }

    private List<Integer> givenNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }
}
