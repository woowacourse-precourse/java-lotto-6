package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrizeCalculatorTest {

    private final PrizeCalculator prizeCalculator = new PrizeCalculator();

    @Test
    @DisplayName("상금을 올바르게 계산하여 반환")
    public void testCalculatePrize() {
        List<Rank> ranks1 = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
        List<Rank> ranks2 = Arrays.asList(Rank.SECOND, Rank.SECOND, Rank.FOURTH);
        List<Rank> ranks3 = Collections.emptyList();

        assertAll(() -> {
            assertThat(prizeCalculator.calculatePrize(ranks1)).isEqualTo(2_030_555_000L);
            assertThat(prizeCalculator.calculatePrize(ranks2)).isEqualTo(60_100_000L);
            assertThat(prizeCalculator.calculatePrize(ranks3)).isEqualTo(0L);
        });
    }
}
