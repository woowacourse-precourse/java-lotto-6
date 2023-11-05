package lotto.winning;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnalystTest {
    Analyst analyst = new Analyst();

    HashMap<String, List<Integer>> mockUpdatedPrizes =
            analyst.updatePrizes(
                    List.of(2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6),
                    List.of(4, 3, 3, 2, 1, 1, 0, 1, 2, 0, 0, 1));

    @Test
    public void countPrizeTest() {
        assertThat(mockUpdatedPrizes.get("first").get(PrizeIndex.COUNT.getNumber())).isEqualTo(1);
        assertThat(mockUpdatedPrizes.get("second").get(PrizeIndex.COUNT.getNumber())).isEqualTo(1);
        assertThat(mockUpdatedPrizes.get("third").get(PrizeIndex.COUNT.getNumber())).isEqualTo(2);
        assertThat(mockUpdatedPrizes.get("fourth").get(PrizeIndex.COUNT.getNumber())).isEqualTo(3);
        assertThat(mockUpdatedPrizes.get("fifth").get(PrizeIndex.COUNT.getNumber())).isEqualTo(4);
    }

    @Test
    public void sumPrizeTest() {
        assertThat(mockUpdatedPrizes.get("first").get(PrizeIndex.PRIZE.getNumber())).isEqualTo(2000000000);
        assertThat(mockUpdatedPrizes.get("second").get(PrizeIndex.PRIZE.getNumber())).isEqualTo(30000000);
        assertThat(mockUpdatedPrizes.get("third").get(PrizeIndex.PRIZE.getNumber())).isEqualTo(1500000 * 2);
        assertThat(mockUpdatedPrizes.get("fourth").get(PrizeIndex.PRIZE.getNumber())).isEqualTo(50000 * 3);
        assertThat(mockUpdatedPrizes.get("fifth").get(PrizeIndex.PRIZE.getNumber())).isEqualTo(5000 * 4);
    }

    @Test
    public void returnRatioTest() {
        assertThat(analyst.calculateReturnRatio(mockUpdatedPrizes, 1000000)).isEqualTo(203317.0);
    }
}