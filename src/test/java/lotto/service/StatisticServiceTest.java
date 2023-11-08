package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoCondition;
import lotto.model.LottoPrize;
import lotto.model.LottoStatistic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class StatisticServiceTest {
    private final static int LOTTO_PRICE = LottoCondition.LOTTO_PRICE.getNumber();
    private StatisticService statisticService;
    private Map<Lotto, LottoPrize> results;

    @BeforeEach
    void setUp() {
        statisticService = new StatisticService();
        results = new HashMap<>();
        results.put(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    LottoPrize.FIRST_PRIZE);
        results.put(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                    LottoPrize.SECOND_PRIZE);
        results.put(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                    LottoPrize.SECOND_PRIZE);
        results.put(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                    LottoPrize.SECOND_PRIZE);
        results.put(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                    LottoPrize.FIFTH_PRIZE);
        results.put(new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)),
                    null);
    }

    @Test
    void testCalculatePrize() {
        LottoStatistic lottoStatistic = statisticService.calculateLottoStatistics(results);
        int expectedCount = 3;
        int actualCount = lottoStatistic.getLottoStatistic().get(LottoPrize.SECOND_PRIZE);

        assertThat(actualCount).isEqualTo(expectedCount);
    }
    @Test
    void testCalculateYield() {
        int totalPrize = LottoPrize.FIRST_PRIZE.getPrize() +
            3 * LottoPrize.SECOND_PRIZE.getPrize() +
            LottoPrize.FIFTH_PRIZE.getPrize();
        int totalPrice = results.size() * LOTTO_PRICE;

        double expectedYield = ((double) totalPrize / totalPrice) * 100;
        expectedYield = Math.round(expectedYield * 100.0) / 100.0;

        double actualYield = statisticService.calculateYield(results, LOTTO_PRICE);

        assertThat(actualYield).isEqualTo(expectedYield);
    }
}
