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

    @Test
    void calculateTotalPrizeForRank() {
    }

    @Test
    void calculateTotalPrize() {
    }
}