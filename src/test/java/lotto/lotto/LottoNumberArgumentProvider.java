package lotto.lotto;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LottoNumberArgumentProvider {

    static Stream<Arguments> provideCorrectInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12)),
                Arguments.of(List.of(13, 14, 15, 16, 17, 18)),
                Arguments.of(List.of(19, 20, 21, 22, 23, 24)),
                Arguments.of(List.of(25, 26, 27, 28, 29, 30)),
                Arguments.of(List.of(31, 32, 33, 34, 35, 36)),
                Arguments.of(List.of(37, 38, 39, 40, 41, 42)),
                Arguments.of(List.of(43, 44, 45, 1, 2, 3))
        );
    }

    static Stream<Arguments> provideExceptionInput() {
        return Stream.of(
                Arguments.of(List.of(46, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 46, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 46, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 46, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 46, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }
}
