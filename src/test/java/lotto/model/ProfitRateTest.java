package lotto.model;

import static lotto.model.LottoInfo.ONE_LOTTO_PRICE;
import static lotto.model.LottoRank.FIFTH_RANK;
import static lotto.model.LottoRank.FIRST_RANK;
import static lotto.model.LottoRank.FOURTH_RANK;
import static lotto.model.LottoRank.SECOND_RANK;
import static lotto.model.LottoRank.THIRD_RANK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.Map;
import lotto.vo.BuyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @DisplayName("통계에서 받아온 맵을 통해 수익율을 계산한다.")
    @Test
    void calculateRateOfProfit_test() {
        // given
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        result.put(FIRST_RANK, 1);
        result.put(SECOND_RANK, 2);
        result.put(THIRD_RANK, 3);
        result.put(FOURTH_RANK, 4);
        result.put(LottoRank.FIFTH_RANK, 10);

        BuyAmount buyAmount = new BuyAmount(ONE_LOTTO_PRICE.getValue() * 100);

        // when
        ProfitRate profitRate = ProfitRate.createProfitRate(result, buyAmount);
        double expectedRate = (1 * FIRST_RANK.getPrizeMoney() +
                2 * SECOND_RANK.getPrizeMoney() +
                3 * THIRD_RANK.getPrizeMoney() +
                4 * FOURTH_RANK.getPrizeMoney() +
                10 * FIFTH_RANK.getPrizeMoney()) / (double) buyAmount.amount() * 100;

        // then
        assertEquals(expectedRate, profitRate.getRate());
    }
}
