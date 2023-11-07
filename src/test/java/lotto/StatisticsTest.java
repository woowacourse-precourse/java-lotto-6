package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.statistics.LottoRank;
import lotto.domain.statistics.LottoResult;
import lotto.domain.statistics.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class StatisticsTest {

    WinningStatistics winningStatistics;

    @BeforeEach
    void init() {
        winningStatistics = new WinningStatistics();
    }


    @ParameterizedTest
    @MethodSource("provideRankAndCount")
    void 생성한_통계_결과가_정확하게_등수별_복권_개수를_갖는다(LottoRank rank, int count) {
        //given
        List<LottoResult> lottoResults = List.of(
                new LottoResult(0,false),
                new LottoResult(0,true),
                new LottoResult(1,false),
                new LottoResult(1,true),
                new LottoResult(2,false),
                new LottoResult(2,true),
                new LottoResult(3,false),
                new LottoResult(3,true),
                new LottoResult(4,false),
                new LottoResult(4,true),
                new LottoResult(5,false),
                new LottoResult(5,true),
                new LottoResult(6,false)
        );

        //when
        winningStatistics.updateStatistics(lottoResults);
        int countOfRank = winningStatistics.getCountOfRank(rank);

        //then
        assertThat(countOfRank).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("provideResultAndPrize")
    void 생성한_통계_결과가_장확한_총_상금_금액을_갖는다(List<LottoResult> lottoResults,long prize){
        //when
        winningStatistics.updateStatistics(lottoResults);

        //then
        assertThat(winningStatistics.getPrizeMoney()).isEqualTo(prize);
    }

    private static Stream<Arguments> provideRankAndCount() {
        return Stream.of(
                Arguments.of(LottoRank.FIFTH_PLACE,2),
                Arguments.of(LottoRank.FOURTH_PLACE,2),
                Arguments.of(LottoRank.THIRD_PLACE,1),
                Arguments.of(LottoRank.SECOND_PLACE,1),
                Arguments.of(LottoRank.FIRST_PLACE,1)
        );
    }

    private static Stream<Arguments> provideResultAndPrize() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new LottoResult(0,false),
                                new LottoResult(1,false),
                                new LottoResult(2,false),
                                new LottoResult(3,false),
                                new LottoResult(3,true),
                                new LottoResult(3,true)
                        ), 15000
                ),
                Arguments.of(
                        List.of(
                                new LottoResult(0,false),
                                new LottoResult(0,false),
                                new LottoResult(1,false),
                                new LottoResult(2,false),
                                new LottoResult(2,true),
                                new LottoResult(6,false)
                        ), 2000000000
                ),
                Arguments.of(
                        List.of(
                                new LottoResult(0,false),
                                new LottoResult(1,false),
                                new LottoResult(1,false),
                                new LottoResult(3,false),
                                new LottoResult(5,false),
                                new LottoResult(5,true)
                        ), 31505000
                )
        );
    }



}
