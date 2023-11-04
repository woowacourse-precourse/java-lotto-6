package lotto.computer;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class MoneyArgumentsProvider {

    static Stream<Arguments> provideCorrectInput() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(Arguments::of);
    }
}
