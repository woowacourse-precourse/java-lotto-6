package lotto.domain.prize.statistics;

import static lotto.fixture.Fixture.createContinuousLotto;
import static lotto.fixture.Fixture.createContinuousLottoNumbers;
import static lotto.fixture.Fixture.createContinuousPrizeNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeNumber;
import lotto.domain.prize.PrizeNumberType;
import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.domain.prize.ranking.rule.PrizeRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 통계 도메인")
class PrizeStatisticsTest {

    @Test
    @DisplayName("2등과 3등은 같은 개수로 판단하지만, 보너스에 따라 달라져야 한다.")
    void Should_Not_Overlap_When_Second_And_Third_Ranking() {
        //given
        final LottoGroup lottoGroup = new LottoGroup(
                List.of(
                        createContinuousLotto(2, 7),
                        createContinuousLottoNumbers(2, 3, 4, 5, 6, 8)
                )
        );

        final Prize prize = new Prize(createContinuousPrizeNumbers(1, 6),
                new PrizeNumber(7, PrizeNumberType.BONUS)
        );

        final PrizeRankingCount expected = new PrizeRankingCount(
                new EnumMap<>(
                        Map.of(
                                PrizeRanking.FIRST,
                                0,
                                PrizeRanking.SECOND,
                                1,
                                PrizeRanking.THIRD,
                                1,
                                PrizeRanking.FOURTH,
                                0,
                                PrizeRanking.FIFTH,
                                0
                        )
                )
        );

        //when
        final PrizeStatistics prizeStatistics = new PrizeStatistics(lottoGroup, prize);
        final PrizeRankingCount actual = prizeStatistics.getCountsByPrizeRanking();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("1등 부터 5등까지 모든 케이스를 계산한다.")
    void Should_Count_When_All_Prize_Cases() {
        //given
        final LottoGroup lottoGroup = new LottoGroup(
                List.of(
                        createContinuousLotto(1, 6),
                        createContinuousLotto(2, 7),
                        createContinuousLottoNumbers(2, 3, 4, 5, 6, 8),
                        createContinuousLotto(3, 8),
                        createContinuousLotto(4, 9)
                )
        );

        final Prize prize = new Prize(createContinuousPrizeNumbers(1, 6),
                new PrizeNumber(7, PrizeNumberType.BONUS)
        );

        final PrizeRankingCount expected = new PrizeRankingCount(
                new EnumMap<>(
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
                )
        );

        //when
        final PrizeStatistics prizeStatistics = new PrizeStatistics(lottoGroup, prize);
        final PrizeRankingCount actual = prizeStatistics.getCountsByPrizeRanking();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
