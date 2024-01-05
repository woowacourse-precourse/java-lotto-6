package lotto.view.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class WinningNumbersInputTestProvider {

    public static Stream<Arguments> provideValuesForNormalInputTest() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("45,2,3,20,5,1", List.of(45, 2, 3, 20, 5, 1)),
                Arguments.of("1,44,3,4,5,0", List.of(1, 44, 3, 4, 5, 0))
        );
    }

    public static Stream<Arguments> provideValuesForNotNumericExceptionTest() {
        return Stream.of(
                Arguments.of("1,2,-,4,5,6"),
                Arguments.of("1,2,3,4,we,6"),
                Arguments.of("1,wer,3wer,5#,6"),
                Arguments.of(" "),
                Arguments.of("")
        );
    }
}
