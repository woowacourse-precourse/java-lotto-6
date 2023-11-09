package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningResultTest {

    private static final int RANK_SIZE_EXCEPT_NONE = LottoRank.values().length - 1;

    /*
        {1등: 2개},
        {2등: 1개},
        {3등: 2개},
        {4등: 3개},
        {5등: 5개}
    */
    private static final List<WinningSummary> winningSummaries = List.of(
            WinningSummary.from(LottoRank.FIRST, 2),
            WinningSummary.from(LottoRank.SECOND, 1),
            WinningSummary.from(LottoRank.THIRD, 2),
            WinningSummary.from(LottoRank.FOURTH, 3),
            WinningSummary.from(LottoRank.FIFTH, 5)
    );

    private static final WinningResult winningResult = new WinningResult();

    @BeforeAll
    static void setUp() {
        winningSummaries.forEach(winningResult::addItem);
    }


    @DisplayName("주어진 당첨 내역에 대한 정보를 반환한다.")
    @Test
    void givenWinningSummaries_Then_AllDetailsReturn() {
        // when
        final List<WinningSummary> summaries = winningResult.getResults();

        // then
        assertThat(summaries.size()).isEqualTo(RANK_SIZE_EXCEPT_NONE);

        // 당첨 금액 비교
        final List<Long> winningPrizes = getProperties(
                summaries,
                WinningSummary::prize
        );
        assertThat(winningPrizes).containsExactly(
                LottoPrize.FIFTH.getAmount(),
                LottoPrize.FOURTH.getAmount(),
                LottoPrize.THIRD.getAmount(),
                LottoPrize.SECOND.getAmount(),
                LottoPrize.FIRST.getAmount()
        );

        // 당첨 기준 별 빈도수 비교
        final List<Long> rankFrequencies = getProperties(
                summaries,
                WinningSummary::frequency
        );
        assertThat(rankFrequencies).containsExactly(5L, 3L, 2L, 1L, 2L);

        // 당첨 기준 별 일치하는 번호의 개수 비교
        final List<Integer> numberOfMatchesByRank = getProperties(
                summaries,
                WinningSummary::numberOfMatches
        );
        assertThat(numberOfMatchesByRank).containsExactly(
                MatchCount.THREE.getCount(),
                MatchCount.FOUR.getCount(),
                MatchCount.FIVE.getCount(),
                MatchCount.FIVE.getCount(),
                MatchCount.SIX.getCount()
        );
    }

    private <R> List<R> getProperties(
            final List<WinningSummary> summaries,
            final Function<WinningSummary, R> expression
    ) {
        return summaries.stream()
                .map(expression)
                .toList();
    }

    @DisplayName("주어진 당첨 내역에 대한 총 당첨 금액을 구한다.")
    @Test
    void givenWinningSummaries_Then_TotalWinningAmountReturns() {
        // when
        final BigDecimal totalWinningAmount = winningResult.sumUpWinningAmount();

        // then
        /*
            {1등: 2개} -> 2,000,000,000 * 2 = 4,000,000,000
            {2등: 1개} -> 30,000,000 * 1 = 30,000,000
            {3등: 2개} -> 1,500,000 * 2 = 3,000,000
            {4등: 3개} -> 50,000 * 3 = 150,000
            {5등: 5개} -> 5,000 * 5 = 25,000
            -----------------------------------------------
            = 4,033,175,000
        */
        final BigDecimal expectedAmount = BigDecimal.valueOf(4_033_175_000L);
        assertThat(totalWinningAmount).isEqualByComparingTo(expectedAmount);
    }

    @DisplayName("구입 금액에 대한 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "8000:50414687.5", "5000:80663500",
            "55000:7333045.5", "3105000:129892.9"
    }, delimiter = ':')
    void givenPurchaseAmount_Then_ProfitRateReturns(
            final long purchaseAmount,
            final double expectedProfit
    ) {
        // given
        final Money money = Money.of(purchaseAmount);

        // when
        final BigDecimal profitRate = winningResult.calculateProfitRate(money);

        // then
        /*
            4,033,175,000 / 8,000 * 100 = 50,414,687.5%
            4,033,175,000 / 5,000 * 100 = 80,663,500%
            4,033,175,000 / 5,5000 * 100 = 7,333,045.5%
            4,033,175,000 / 3,105,000 * 100 = 129,892.9%
        */
        assertThat(profitRate.doubleValue()).isEqualTo(expectedProfit, withPrecision(0d));
    }
}
