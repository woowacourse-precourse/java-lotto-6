package lotto.view.output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.domain.prize.ranking.rule.PrizeRanking;
import lotto.domain.prize.statistics.EarningRate;
import lotto.domain.prize.statistics.TotalPrizeAmount;
import lotto.view.output.writer.ConsoleWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 통계 출력 뷰")
class LottoStatisticsOutputViewTest {
    private LottoStatisticsOutputView lottoStatisticsOutputView;
    private ConsoleWriter mockConsoleWriter;

    private PrizeRankingCount prizeRankingCount;
    private EarningRate earningRate;

    @BeforeEach
    void setUp() {
        mockConsoleWriter = mock(ConsoleWriter.class);
        lottoStatisticsOutputView = new LottoStatisticsOutputView(mockConsoleWriter);

        prizeRankingCount = new PrizeRankingCount(
                new EnumMap<>(
                        Map.of(
                                PrizeRanking.FIRST,
                                0,
                                PrizeRanking.SECOND,
                                0,
                                PrizeRanking.THIRD,
                                0,
                                PrizeRanking.FOURTH,
                                1,
                                PrizeRanking.FIFTH,
                                2
                        )
                )
        );
        final TotalPrizeAmount totalPrizeAmount = TotalPrizeAmount.from(prizeRankingCount);
        earningRate = new EarningRate(new LottoPurchaseAmount(100000), totalPrizeAmount);
    }

    @Test
    @DisplayName("구매한 로또 개수를 출력합니다.")
    void Should_Print_Prize_Statistics_Message_When_Print_Prize_Statistics() {
        //when
        lottoStatisticsOutputView.printPrizeStatistics(prizeRankingCount, earningRate);

        //then
        verify(mockConsoleWriter).println("당첨 통계");
    }

    @Test
    @DisplayName("구매한 로또 개수 이후 구분 선을 출력합니다.")
    void Should_Print_Horizontal_Line_When_Print_Prize_Statistics() {
        //when
        lottoStatisticsOutputView.printPrizeStatistics(prizeRankingCount, earningRate);

        //then
        verify(mockConsoleWriter).println("---");
    }

    @Test
    @DisplayName("당첨 기준과 당첨 금액을 알려주고, 그에 맞는 당첨 개수를 출력합니다.")
    void Should_Print_Prize_Ranking_When_Print_Prize_Statistics() {
        //when
        lottoStatisticsOutputView.printPrizeStatistics(prizeRankingCount, earningRate);

        //then
        verify(mockConsoleWriter).println("6개 일치 (2,000,000,000원) - 0개");
        verify(mockConsoleWriter).println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        verify(mockConsoleWriter).println("5개 일치 (1,500,000원) - 0개");
        verify(mockConsoleWriter).println("4개 일치 (50,000원) - 1개");
        verify(mockConsoleWriter).println("3개 일치 (5,000원) - 2개");
    }

    @Test
    @DisplayName("로또 구입 금액에서 총 당첨 금액을 나눈 수익률을 알려줍니다.")
    void Should_Print_Earning_Rate_When_Print_Prize_Statistics() {
        //when
        lottoStatisticsOutputView.printPrizeStatistics(prizeRankingCount, earningRate);

        //then
        verify(mockConsoleWriter).println("총 수익률은 60.0%입니다.");
    }
}
