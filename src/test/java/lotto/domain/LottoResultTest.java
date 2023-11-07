package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class LottoResultTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:FIFTH:500.0", "10000:FOURTH:500.0", "10000:THIRD:15000.0"}, delimiterString = ":")
    public void 구매_금액과_당첨_순위에_따른_총_수익률을_구할_수_있다(int purchaseMoney, Rank winningRank, double expectedEarningsRate) {
        // given
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(purchaseMoney);
        LottoResult lottoResult = new LottoResult(List.of(winningRank));

        // when
        double actualEarningsRate = lottoResult.getTotalEarningsRate(lottoPurchaseMoney);

        // then
        Assertions.assertThat(actualEarningsRate).isEqualTo(expectedEarningsRate);
    }

    @ParameterizedTest
    @MethodSource("provideLottoResultWithRankAndWinningCount")
    public void 구매_금액과_당첨_순위에_따른_총_수익률을_구할_수_있다(LottoResult lottoResult, Rank winningRank, int expectedWinningCount) {
        // when
        Map<Rank, Integer> lottoResultMap = lottoResult.get();
        Integer actualWinningCount = lottoResultMap.get(winningRank);

        // then
        Assertions.assertThat(actualWinningCount).isEqualTo(expectedWinningCount);
    }

    private static Stream<Arguments> provideLottoResultWithRankAndWinningCount() {
        return Stream.of(
                Arguments.of(new LottoResult(List.of(Rank.FIRST, Rank.FIRST, Rank.FIRST)), Rank.FIRST, 3),
                Arguments.of(new LottoResult(List.of(Rank.FIRST, Rank.FIRST, Rank.SECOND)), Rank.FIRST, 2),
                Arguments.of(new LottoResult(List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD)), Rank.SECOND, 1),
                Arguments.of(new LottoResult(List.of(Rank.BLANK, Rank.FIFTH, Rank.THIRD)), Rank.FIFTH, 1),
                Arguments.of(new LottoResult(List.of(Rank.THIRD, Rank.THIRD, Rank.FOURTH)), Rank.FOURTH, 1),
                Arguments.of(new LottoResult(List.of(Rank.SECOND, Rank.FIRST, Rank.SECOND)), Rank.SECOND, 2)
                );
    }
}