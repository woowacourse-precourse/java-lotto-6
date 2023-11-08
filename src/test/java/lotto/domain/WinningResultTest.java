package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @Test
    void getTotalPrizeOfGivenRank() {
        WinningResult winningResult = new WinningResult();
        winningResult.updateResult(Rank.FIRST);
        winningResult.updateResult(Rank.FIFTH);
        int totalPrize = winningResult.getTotalPrize();

        assertThat(totalPrize).isEqualTo(Rank.FIRST.getPrize() + Rank.FIFTH.getPrize());
    }
}
