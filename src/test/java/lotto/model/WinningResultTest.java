package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.stub.WinningResultStub;
import org.junit.jupiter.api.Test;

class WinningResultTest extends WinningResultStub {
    @Test
    void create() {
        WinningResult winningResult = WinningResult.create();

        assertThat(winningResult)
                .isInstanceOf(WinningResult.class);
    }

    @Test
    public void getTotalWinningAmount() {
        WinningResult winningResult = WinningResult.create();
        winningResult = winningResult.withIncreasedPlaceCount(FIRST_PLACE_COUNT_INDEX);
        winningResult = winningResult.withIncreasedPlaceCount(FIFTH_PLACE_COUNT_INDEX);


        TotalWinningAmount totalWinningAmount = winningResult.getTotalWinningAmount();

        assertThat(totalWinningAmount.totalWinningAmount()).isEqualTo(BigDecimal.valueOf(TOTAL_WINNING_AMOUNT));
    }
}