package lotto.lotto;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LottoCompareArgumentProvider {

    static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 14, 15, 16), 0),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 11, 12, 13, 14, 15), 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 11, 12, 13, 14), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 11, 12, 13), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 11, 12), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 11), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(6, 5, 4, 3, 2, 1), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 5, 4, 3, 2, 1), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 4, 3, 2, 1), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 3, 2, 1), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 14, 2, 1), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(11, 12, 13, 14, 15, 1), 1)
        );
    }
}
