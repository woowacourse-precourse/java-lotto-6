package lotto.computer;

import java.util.List;
import java.util.stream.Stream;
import lotto.lotto.Lotto;
import org.junit.jupiter.params.provider.Arguments;

public class ResultArgumentsProvider {

    static Stream<Arguments> provideCorrectInput() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(1, 2, 3, 8, 9, 10))
                        )
                        ,
                        List.of(1, 1, 1, 0, 1) //1등, 2등, 3등, 4등, 5등
                ),
                Arguments.of(
                        new Lotto(List.of(5, 9, 17, 28, 31, 45)),
                        32,
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 5, 6, 9, 31, 34)),
                                new Lotto(List.of(13, 17, 27, 31, 44, 45)),
                                new Lotto(List.of(5, 9, 17, 28, 31, 32))
                        )
                        ,
                        List.of(0, 1, 0, 0, 2)
                )
        );
    }
}
