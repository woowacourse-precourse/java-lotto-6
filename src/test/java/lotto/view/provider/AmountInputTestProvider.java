package lotto.view.provider;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class AmountInputTestProvider {

    public static Stream<Arguments> provideValuesForNormalInput() {
        return Stream.of(
                Arguments.of("1000", 1000),
                Arguments.of("2000", 2000),
                Arguments.of("3333", 3333),
                Arguments.of("0", 0),
                Arguments.of("-1", -1)
        );
    }

    public static Stream<Arguments> provideValuesForNotNumericException() {
        return Stream.of(
                Arguments.of("100-0"),
                Arguments.of("20-00"),
                Arguments.of(" er66-"),
                Arguments.of(" "),
                Arguments.of("")
        );
    }
}
