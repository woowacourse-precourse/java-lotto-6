package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeResultTest {
    @DisplayName("PrizeResult에 수상 결과를 추가할 수 있다.")
    @Test
    void addPrize_Success() {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.addPrize(Prize.FIRST);
        prizeResult.addPrize(Prize.THIRD);
        prizeResult.addPrize(Prize.THIRD);

        Map<Prize, Integer> result = prizeResult.getResult();
        assertThat(result).containsEntry(Prize.FIRST, 1);
        assertThat(result).containsEntry(Prize.THIRD, 2);
        assertThat(result).containsEntry(Prize.SECOND, 0);
    }

    @DisplayName("PrizeResult의 수상 결과로 수익률을 계산할 수 있다.")
    @Test
    void calculateProfitRate_Success() {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.addPrize(Prize.FOURTH);
        prizeResult.addPrize(Prize.FIFTH);
        prizeResult.addPrize(Prize.NONE);

        double profitRate = prizeResult.calculateProfitRate(10_000);
        assertThat(profitRate).isEqualTo(550);
    }

}