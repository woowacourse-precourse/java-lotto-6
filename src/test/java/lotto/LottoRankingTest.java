package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("등수 결과로 총 당첨된 금액을 계산할 수 있다.")
public class LottoRankingTest {
    @ParameterizedTest
    @MethodSource("getTotalPrizeMoneyData")
    @DisplayName("등수 리스트를 받아 당첨 금액으로 계산한다.")
    void 당첨금액계산_정상처리(List<LottoRanking> lottoRankings, Amount totalPrizeMoney) {
        Amount resultTotalPrizeMoney = LottoRanking.getTotalPrizeMoney(lottoRankings);
        Assertions.assertThat(resultTotalPrizeMoney).isEqualTo(totalPrizeMoney);
    }

    static Stream<Arguments> getTotalPrizeMoneyData() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRanking.FIFTH_PRIZE,
                                LottoRanking.FIFTH_PRIZE),
                        new Amount("10000")),
                Arguments.of(
                        List.of(LottoRanking.FIRST_PRIZE),
                        new Amount("2000000000")),
                Arguments.of(
                        List.of(LottoRanking.SECOND_PRIZE,
                                LottoRanking.FOURTH_PRIZE,
                                LottoRanking.THIRD_PRIZE),
                        new Amount("31550000"))
        );
    }
}
