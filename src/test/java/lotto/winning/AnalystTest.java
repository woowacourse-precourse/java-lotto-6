package lotto.winning;


import static lotto.winning.Prize.FIFTH;
import static lotto.winning.Prize.FIRST;
import static lotto.winning.Prize.FOURTH;
import static lotto.winning.Prize.SECOND;
import static lotto.winning.Prize.THIRD;
import static lotto.winning.Tally.COUNT;
import static lotto.winning.Tally.AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnalystTest {
    Analyst analyst = new Analyst();

    /**
     * Mock data for prize calculation tests.
     * The first list represents the number of matched main lotto numbers for each ticket.
     * The second list represents the number of matched bonus numbers for each ticket.
     */
    HashMap<Prize, HashMap<Tally, Integer>> mockUpdatedPrizes =
            analyst.updatePrizes(
                    List.of(2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6), // Main number matches per ticket
                    List.of(4, 3, 3, 2, 1, 1, 0, 1, 2, 0, 0, 1)); // Bonus number matches per ticket

    @Test
    public void countPrizeTest() {
        assertThat(mockUpdatedPrizes.get(FIRST).get(COUNT)).isEqualTo(1);
        assertThat(mockUpdatedPrizes.get(SECOND).get(COUNT)).isEqualTo(1);
        assertThat(mockUpdatedPrizes.get(THIRD).get(COUNT)).isEqualTo(2);
        assertThat(mockUpdatedPrizes.get(FOURTH).get(COUNT)).isEqualTo(3);
        assertThat(mockUpdatedPrizes.get(FIFTH).get(COUNT)).isEqualTo(4);
    }

    @Test
    public void sumPrizeTest() {
        assertThat(mockUpdatedPrizes.get(FIRST).get(AMOUNT)).isEqualTo(2000000000);
        assertThat(mockUpdatedPrizes.get(SECOND).get(AMOUNT)).isEqualTo(30000000);
        assertThat(mockUpdatedPrizes.get(THIRD).get(AMOUNT)).isEqualTo(1500000 * 2);
        assertThat(mockUpdatedPrizes.get(FOURTH).get(AMOUNT)).isEqualTo(50000 * 3);
        assertThat(mockUpdatedPrizes.get(FIFTH).get(AMOUNT)).isEqualTo(5000 * 4);
    }

    @Test
    public void returnRatioTest() {
        assertThat(analyst.calculateReturnRatio(mockUpdatedPrizes, 1000000)).isEqualTo(203317.0);
    }
}