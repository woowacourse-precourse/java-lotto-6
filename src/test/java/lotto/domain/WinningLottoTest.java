package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {

    @DisplayName("로또를 입력받아 비교하여 랭킹을 반환한다")
    @ParameterizedTest
    @MethodSource("provideLottoNumberAndExpectedRankings")
    void calculateRankingSuccessTest(WinningLotto winningLotto, Lotto lotto, LottoRanking ranking) {

        // given
        // when
        LottoRanking lottoRanking = winningLotto.calculateRanking(lotto);

        // then
        assertThat(ranking).isEqualTo(lottoRanking);
    }

    private static Stream<Arguments> provideLottoNumberAndExpectedRankings() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return Stream.of(
                Arguments.of(winningLotto, new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRanking.FIRST),
                Arguments.of(winningLotto, new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRanking.SECOND),
                Arguments.of(winningLotto, new Lotto(List.of(1, 2, 3, 4, 5, 8)), LottoRanking.THIRD),
                Arguments.of(winningLotto, new Lotto(List.of(1, 2, 3, 4, 8, 9)), LottoRanking.FOURTH),
                Arguments.of(winningLotto, new Lotto(List.of(1, 2, 3, 8, 9, 10)), LottoRanking.FIFTH),
                Arguments.of(winningLotto, new Lotto(List.of(1, 2, 8, 9, 10, 11)), LottoRanking.NO_LUCK),
                Arguments.of(winningLotto, new Lotto(List.of(1, 12, 8, 9, 10, 11)), LottoRanking.NO_LUCK),
                Arguments.of(winningLotto, new Lotto(List.of(13, 12, 8, 9, 10, 11)), LottoRanking.NO_LUCK)
        );
    }
}
