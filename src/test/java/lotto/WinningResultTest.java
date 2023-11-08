package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Rank;
import lotto.domain.WinningResult;
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
