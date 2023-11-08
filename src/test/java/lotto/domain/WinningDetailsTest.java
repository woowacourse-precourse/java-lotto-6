package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.prize.Prize;
import lotto.domain.prize.WinningDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningDetailsTest {
    private WinningDetails winningDetails;

    @BeforeEach
    void setUp() {
        winningDetails = WinningDetails.createWinningDetails();
    }

    @DisplayName("상금 수량을 증가시키는 기능 테스트")
    @Test
    void increasePrizeAmount() {
        Prize prize = Prize.FIFTH_PLACE;
        int expectedAmount = 2;

        winningDetails.increasePrizeAmount(prize);
        winningDetails.increasePrizeAmount(prize);
        int prizeAmount = winningDetails.getPrizeAmount(prize);

        assertThat(prizeAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("등수별 총 상금을 계산하는 기능 테스트")
    @Test
    void calculateTotalPrizeForRank() {
        Prize prize = Prize.FIFTH_PLACE;
        winningDetails.increasePrizeAmount(prize);
        winningDetails.increasePrizeAmount(prize);
        int expectedPrize = 10_000;

        int totalPrizeForRank = winningDetails.calculateTotalPrizeForRank(prize);

        assertThat(totalPrizeForRank).isEqualTo(expectedPrize);
    }

    @DisplayName("총 상금을 계산하는 기능 테스트")
    @Test
    void calculateTotalPrize() {
        Prize prize = Prize.FIFTH_PLACE;
        winningDetails.increasePrizeAmount(prize);
        winningDetails.increasePrizeAmount(prize);

        prize = Prize.FIRST_PLACE;
        winningDetails.increasePrizeAmount(prize);
        int expectedTotalPrize = 2_000_010_000;

        int totalPrize = winningDetails.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}