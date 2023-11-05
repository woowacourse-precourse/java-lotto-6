package lotto;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class MethodSourceTest {

    protected static Stream<Arguments> generateInvalidSizeLottoNumbersArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    protected static Stream<Arguments> generateDuplicateLottoNumbersArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(1, 2, 3, 3, 2, 1))
        );
    }

    protected static Stream<Arguments> generateOutOfRangeLottoNumbersArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 100)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(-1, 1, 2, 3, 4, 5))
        );
    }
}
