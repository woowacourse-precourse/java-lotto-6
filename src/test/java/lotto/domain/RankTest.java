package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("당첨 번호와 로또로 등수를 계산할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getRankByLottoAndWinningNumber(Lotto lotto, WinningNumber winningNumber, Rank expected) {

        Rank actual = Rank.of(lotto, winningNumber);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> getRankByLottoAndWinningNumber() {
        return Stream.of(
                Arguments.of(createLotto(1, 2, 3, 4, 5, 6), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(createLotto(1, 2, 3, 4, 5, 7), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.SECOND),
                Arguments.of(createLotto(1, 2, 3, 4, 5, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.THIRD),
                Arguments.of(createLotto(1, 2, 3, 4, 7, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.FOURTH),
                Arguments.of(createLotto(1, 2, 3, 4, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.FOURTH),
                Arguments.of(createLotto(1, 2, 3, 7, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.FIFTH),
                Arguments.of(createLotto(1, 2, 3, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.FIFTH),
                Arguments.of(createLotto(1, 2, 42, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.NONE),
                Arguments.of(createLotto(1, 2, 7, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.NONE),
                Arguments.of(createLotto(1, 41, 42, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.NONE),
                Arguments.of(createLotto(1, 7, 42, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.NONE),
                Arguments.of(createLotto(40, 41, 42, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.NONE),
                Arguments.of(createLotto(7, 41, 42, 43, 44, 45), createWinningNumber(7, 1, 2, 3, 4, 5, 6), Rank.NONE)
        );
    }

    @DisplayName("총 상금액을 구할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getTotalPrize(EnumMap<Rank, Integer> rankToCount, long expected) {

        long totalPrize = Rank.getTotalPrize(rankToCount);

        assertThat(totalPrize).isEqualTo(expected);
    }

    public static Stream<Arguments> getTotalPrize() {
        return Stream.of(
                Arguments.of(createRankToCount(Rank.NONE, Rank.NONE), 0L),
                Arguments.of(createRankToCount(Rank.NONE, Rank.FIFTH), 5000L),
                Arguments.of(createRankToCount(Rank.FIFTH, Rank.FIFTH), 5000L + 5000L),
                Arguments.of(createRankToCount(Rank.FIFTH, Rank.FIFTH, Rank.FIRST), 2_000_000_000L + 5000L + 5000L)
        );
    }

    private static Lotto createLotto(Integer... nums) {
        return new Lotto(Arrays.asList(nums));
    }

    private static WinningNumber createWinningNumber(int bonusNumber, Integer... nums) {
        return new WinningNumber(createLotto(nums), new LottoNumber(bonusNumber));
    }

    private static EnumMap<Rank, Integer> createRankToCount(Rank... ranks) {
        EnumMap<Rank, Integer> rankToInteger = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            add(rankToInteger, rank);
        }
        return rankToInteger;
    }

    private static void add(EnumMap<Rank, Integer> map, Rank rank) {
        map.put(rank, map.getOrDefault(rank, 0) + 1);
    }
}
