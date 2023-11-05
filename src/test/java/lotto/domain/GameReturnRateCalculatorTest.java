package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수익률 확인")
class GameReturnRateCalculatorTest {

    @DisplayName("수익률 정상 리턴")
    @Test
    void getReturnRate() {
        // given
        int givenBuyPrice = 10;
        Map<Rank, Integer> givenGameResult = Map.of(
                Rank.RANK_1, 1,
                Rank.RANK_2, 2,
                Rank.RANK_3, 0,
                Rank.RANK_4, 0,
                Rank.RANK_5, 3,
                Rank.UNRANK, 5
        );

        // 2000000000 + 2 * 30000000 + 3 * 5000 = 2,060,015,000
        // 2,060,015,000 / (10 * 1000) * 100 = 20,600,150
        double expectedResult = 20600150;

        // when
        double realResult = GameReturnRateCalculator.getReturnRate(givenGameResult, givenBuyPrice);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }
}