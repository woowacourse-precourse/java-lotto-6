package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsResultTest {

    @DisplayName("최종 수익률은 (상금/구매 금액)* 100 % 이다. ")
    @Test
    void 수익률_계산_기능() {
        //given
        final int purchaseAmount = 10000;
        final int lottoPrice = 1000;
        final List<Result> results = List.of(Result.FOUR);
        final StatisticsResult statisticsResult = new StatisticsResult(purchaseAmount, lottoPrice);
        statisticsResult.addLottoResults(results);

        //when
        double finalReturnRate = statisticsResult.getFinalReturnRate();

        //then
        assertThat(500.0).isEqualTo(finalReturnRate);
    }

    @DisplayName("결과가 포함된 Map생성 확인")
    @Test
    void 결과별_최종_개수_확인() {
        //given
        StatisticsResult statisticsResult = new StatisticsResult(3000, 1000);
        statisticsResult.addLottoResults(List.of(Result.THREE, Result.BONUS, Result.FIVE));

        //when
        Map<Result, Integer> finalResult = statisticsResult.getFinalResult();

        //then
        assertThat(finalResult.get(Result.THREE)).isEqualTo(1);
        assertThat(finalResult.get(Result.FOUR)).isEqualTo(0);
        assertThat(finalResult.get(Result.FIVE)).isEqualTo(1);
        assertThat(finalResult.get(Result.BONUS)).isEqualTo(1);
        assertThat(finalResult.get(Result.SIX)).isEqualTo(0);
    }

    @DisplayName("로또개수 반환 기능 확인")
    @Test
    void 로또개수_계산_기능() {
        //given
        final int purchaseAmount = 13000;
        final int lottoPrice = 1000;
        StatisticsResult statisticsResult = new StatisticsResult(purchaseAmount, lottoPrice);

        //when
        int lottoCount = statisticsResult.caculateLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(13);
    }
}
