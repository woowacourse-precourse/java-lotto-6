package lotto.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.PlayerLotto;

public class TestHelper {
    public static List<Integer> parser(String charactersWithCommas) {
        return Arrays.stream(charactersWithCommas.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static Stream<List<Integer>> createInvalidCountNumbers() {
        return Stream.of(
                List.of(1),
                List.of(11, 12),
                List.of(23, 24, 25),
                List.of(36, 37, 38, 39),
                List.of(40, 41, 42, 43, 44),
                List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    public static Stream<List<Integer>> createDuplicateNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 5),
                List.of(11, 12, 13, 14, 15, 11),
                List.of(23, 24, 24, 25, 26, 27),
                List.of(36, 37, 38, 39, 38, 36),
                List.of(40, 41, 42, 43, 44, 43),
                List.of(1, 2, 3, 1, 4, 5)
        );
    }

    public static Stream<List<Integer>> createValidNumbers() {
        return Stream.of(
                List.of(1, 2, 45, 4, 5, 6),
                List.of(13, 45, 44, 32, 11, 12),
                List.of(43, 33, 15, 31, 24, 27),
                List.of(36, 31, 1, 11, 12, 13),
                List.of(22, 33, 43, 42, 44, 14),
                List.of(1, 2, 3, 5, 12, 37)
        );
    }

    public static Stream<PlayerLotto> createPlayerLotto() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 5, 7, 27)),
                new Lotto(List.of(1, 4, 5, 7, 2, 28)),
                new Lotto(List.of(7, 4, 2, 3, 30, 37)),
                new Lotto(List.of(2, 3, 7, 11, 12, 13)));

        return Stream.of(new PlayerLotto(lottos));
    }
}
