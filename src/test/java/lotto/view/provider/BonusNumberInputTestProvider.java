package lotto.view.provider;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class BonusNumberInputTestProvider {

    public static Stream<Arguments> provideValuesForNormalInputTest() {
        return Stream.of(
                Arguments.of("2", 2),
                Arguments.of("45", 45),
                Arguments.of("24", 24),
                Arguments.of("0", 0),
                Arguments.of("-10", -10)
        );
    }

    public static Stream<Arguments> provideValuesForNotNumericExceptionTest() {
        return Stream.of(
                Arguments.of("1$0"),
                Arguments.of("@#30"),
                Arguments.of(" swr"),
                Arguments.of(" "),
                Arguments.of("")
        );
    }
}
