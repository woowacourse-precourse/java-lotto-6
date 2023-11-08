package lotto.domain.prize.statistics;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.domain.prize.ranking.rule.PrizeRanking;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("총 당첨 금액 도메인")
class TotalPrizeAmountTest {
    @Test
    @DisplayName("총 당첨 금액은 음수가 될 수 없다.")
    void should_IllegalArgumentExceptionThrown_When_amount_is_negative() {
        //given
        final int negativeTotalPrizeAmount = -1;

        //when, then
        assertThatThrownBy(() -> new TotalPrizeAmount(negativeTotalPrizeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TOTAL_PRIZE_AMOUNT_PRICE_NEGATIVE.getMessage());
    }

    @Test
    @DisplayName("당첨 등수와 갯수로 총 당첨 금액을 계산합니다.")
    void Should_Get_Amount_When_From_Prize_Ranking_Count() {
        //given
        final EnumMap<PrizeRanking, Integer> mapPrizeRankingAndCount = new EnumMap<>(
                Map.of(
                        PrizeRanking.FIRST,
                        1,
                        PrizeRanking.SECOND,
                        1,
                        PrizeRanking.THIRD,
                        1,
                        PrizeRanking.FOURTH,
                        1,
                        PrizeRanking.FIFTH,
                        1
                )
        );
        final PrizeRankingCount prizeRankingCount = new PrizeRankingCount(mapPrizeRankingAndCount);

        final int expected = 2_031_555_000;

        //when
        final TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(prizeRankingCount);
        final long actual = totalPrizeAmount.getAmount();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
