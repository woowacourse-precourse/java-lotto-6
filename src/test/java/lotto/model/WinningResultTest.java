package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @Test
    void create() {
        WinningResult winningResult = WinningResult.create();

        assertThat(winningResult)
                .isInstanceOf(WinningResult.class);
    }

    @Test
    public void getTotalWinningAmount() {
        WinningResult winningResult = WinningResult.create();
        winningResult = winningResult.withIncreasedFirstPlaceCount();
        winningResult = winningResult.withIncreasedFifthPlaceCount();


        TotalWinningAmount totalWinningAmount = winningResult.getTotalWinningAmount();

        assertThat(totalWinningAmount.totalWinningAmount()).isEqualTo(BigDecimal.valueOf(2000005000));
    }
}