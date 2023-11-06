package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("발행한 모든 로또 당첨 결과 확인 기능")
public class SoldLottoTest {
    private static final WinningLotto WINNING_LOTTO = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest
    @MethodSource("checkLottoResultsData")
    @DisplayName("구입한 전체 로또 결과를 학인한다.")
    void 구입로또_결과_정상처리(List<Lotto> lottoTickets, List<LottoRanking> lottoRankings) {
        SoldLotto soldLotto = new SoldLotto(lottoTickets);
        List<LottoRanking> resultLottoRankings = soldLotto.checkLottoResults(WINNING_LOTTO);

        Assertions.assertThat(resultLottoRankings).isEqualTo(lottoRankings);
    }

    static Stream<Arguments> checkLottoResultsData() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        List.of(LottoRanking.FIRST_PRIZE,
                                LottoRanking.SECOND_PRIZE)),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 44, 45))),
                        List.of(LottoRanking.FOURTH_PRIZE)),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 35, 32)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 32)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        List.of(LottoRanking.FOURTH_PRIZE,
                                LottoRanking.THIRD_PRIZE,
                                LottoRanking.SECOND_PRIZE))
        );
    }
}
