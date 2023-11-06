package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatisticTest {

    @DisplayName("주어진 로또에 대해 당첨 내역 통계를 생성한다.")
    @ParameterizedTest
    @MethodSource("getWinningNumberAndLottos")
    void createLottoStatistic(WinningNumbers winningNumbers, Lottos lottos, List<Integer> expected) {
        // given
        LottoStatistic statistic = LottoStatistic.create();

        lottos.stream()
                .map(winningNumbers::match)
                .map(LottoPrize::from)
                .forEach(statistic::add);

        // when
        List<Integer> prizeCount = Arrays.stream(LottoPrize.values())
                .map(statistic::getCountOf)
                .toList();

        // then
        assertThat(prizeCount).isEqualTo(expected);
    }

    private static Stream<Arguments> getWinningNumberAndLottos() {
        return Stream.of(
                Arguments.of(
                        WinningNumbers.of(
                                List.of(1, 2, 3, 4, 5, 6),
                                7
                        ),
                        Lottos.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),   // 1등
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),   // 2등
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),   // 3등
                                new Lotto(List.of(1, 2, 3, 4, 7, 8)),   // 4등
                                new Lotto(List.of(1, 2, 3, 4, 8, 9)),   // 4등
                                new Lotto(List.of(1, 2, 3, 7, 8, 9))    // 5등
                        ),
                        List.of(1, 1, 1, 2, 1, 0)
                )
        );
    }
}
