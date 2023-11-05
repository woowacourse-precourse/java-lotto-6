package lotto.computer;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class MoneyArgumentsProvider {

    static Stream<Arguments> provideCorrectInput() {
        return IntStream.rangeClosed(1, 1000)
                .mapToObj(num ->
                        Arguments.of(Integer.parseInt(num + "000"))
                );
    }

    static Stream<Arguments> provideExceptionInput() {
        return IntStream.rangeClosed(1001, 2000)
                .mapToObj(num ->
                        Arguments.of(Integer.parseInt(num + "000"))
                );
    }
}
