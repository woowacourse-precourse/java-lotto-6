package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.strategy.AutoIssuanceStrategy;

class LottosTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {1, 10, 100})
    @DisplayName("로또 여러 개 생성")
    void givenTotalCount_whenCreateLottos_thenReturn(int totalCount) {
        // when
        Lottos lottos = new Lottos(totalCount, new AutoIssuanceStrategy());

        // then
        assertThat(lottos.count()).isEqualTo(totalCount);
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대 순위 : {1}, 기대 개수 : {2}")
    @MethodSource("provideDataForGetRankResult")
    @DisplayName("로또마다 순위를 구해 결과를 반환: key(순위)-value(개수)")
    void givenData_whenGetRankResult_thenReturnResult(List<Integer> numbers, Rank expectedRank, int expectedCount) {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lottos userLottos = new Lottos(List.of(new Lotto(numbers)));

        // when
        EnumMap<Rank, Integer> result = userLottos.getRankResult(winningLotto);

        // then
        assertThat(result.containsKey(expectedRank)).isTrue();
        assertThat(result.get(expectedRank)).isEqualTo(expectedCount);
    }

    static Stream<Arguments> provideDataForGetRankResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST, 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND, 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD, 1),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), Rank.FOURTH, 1),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), Rank.FIFTH, 1)
        );
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForCalculateTotalReward")
    @DisplayName("총 당첨 금액 계산")
    void givenData_whenCalculateTotalReward_thenReturnCorrectReward(List<Lotto> lottos, long expected) {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lottos userLottos = new Lottos(lottos);

        // when
        long result = userLottos.calculateTotalReward(userLottos.getRankResult(winningLotto));

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideDataForCalculateTotalReward() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7))
                        ), 4_030_000_000L
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                new Lotto(List.of(1, 2, 3, 7, 8, 9))
                        ), 1_605_000L
                )
        );
    }

}
