package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        prizes = Prizes.createPrizes();
    }

    @DisplayName("상금 수량을 증가시키는 기능 테스트")
    @Test
    void increasePrizeAmount() {
        Prize prize = Prize.FIFTH_PLACE;
        int expectedAmount = 2;

        prizes.increasePrizeAmount(prize);
        prizes.increasePrizeAmount(prize);
        int prizeAmount = prizes.getPrizeAmount(prize);

        assertThat(prizeAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("등수별 총 상금을 계산하는 기능 테스트")
    @Test
    void calculateTotalPrizeForRank() {
        Prize prize = Prize.FIFTH_PLACE;
        prizes.increasePrizeAmount(prize);
        prizes.increasePrizeAmount(prize);
        int expectedPrize = 10_000;

        int totalPrizeForRank = prizes.calculateTotalPrizeForRank(prize);

        assertThat(totalPrizeForRank).isEqualTo(expectedPrize);
    }

    @DisplayName("총 상금을 계산하는 기능 테스트")
    @Test
    void calculateTotalPrize() {
        Prize prize = Prize.FIFTH_PLACE;
        prizes.increasePrizeAmount(prize);
        prizes.increasePrizeAmount(prize);

        prize = Prize.FIRST_PLACE;
        prizes.increasePrizeAmount(prize);
        int expectedTotalPrize = 2_000_010_000;

        int totalPrize = prizes.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}