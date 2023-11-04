package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottosTest {

    @DisplayName("Lottos를 생성하고 꺼내면 생성한 로또 번호가 들어있다.")
    @Test
    void getLottosTest() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        List<Lotto> lottoBundle = lottos.getLottos();
        assertThat(lottoBundle.size()).isEqualTo(1);
        assertThat(lottoBundle.get(0).getNumbers()).isEqualTo(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));
    }

    @DisplayName("로또들과 당첨 번호, 보너스 번호를 비교하여 등수를 매긴다.")
    @ParameterizedTest
    @MethodSource("matchTestArguments")
    void matchTest(Lottos purchasedLottos, Lotto winningNumbers, LottoNumber bonusNumber, List<Integer> winCounts) {
        RankResult result = purchasedLottos.determineRank(winningNumbers, bonusNumber);
        assertThat(result.getWinCounts(RankPrize.FIRST_PLACE)).isEqualTo(winCounts.get(0));
        assertThat(result.getWinCounts(RankPrize.SECOND_PLACE)).isEqualTo(winCounts.get(1));
        assertThat(result.getWinCounts(RankPrize.THIRD_PLACE)).isEqualTo(winCounts.get(2));
        assertThat(result.getWinCounts(RankPrize.FOURTH_PLACE)).isEqualTo(winCounts.get(3));
        assertThat(result.getWinCounts(RankPrize.FIFTH_PLACE)).isEqualTo(winCounts.get(4));
    }

    static Stream<Arguments> matchTestArguments() {
        return Stream.of(
                arguments(new Lottos(
                                List.of(
                                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                        new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                        new Lotto(List.of(1, 2, 3, 7, 8, 9))
                                )
                        ),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(7),
                        List.of(1, 1, 1, 1, 1)
                ),
                arguments(new Lottos(
                                List.of(
                                        new Lotto(List.of(1, 13, 17, 21, 34, 43)),
                                        new Lotto(List.of(9, 11, 17, 24, 29, 38)),
                                        new Lotto(List.of(11, 31, 34, 43, 44, 45)),
                                        new Lotto(List.of(31, 43, 34, 45, 11, 7)),
                                        new Lotto(List.of(11, 19, 31, 34, 42, 44))
                                )
                        ),
                        new Lotto(List.of(11, 31, 34, 43, 44, 45)),
                        new LottoNumber(7),
                        List.of(1, 1, 0, 1, 0)
                )
        );
    }
}
