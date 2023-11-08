package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningResultTest {
    @DisplayName("addWinningTicket()은 당첨 티켓을 추가하고, getCount()은 해당 등수의 당첨 티켓 개수를 반환한다.")
    @Test
    void addAndGetWinningTicket() {
        WinningResult winningResult = new WinningResult();
        winningResult.addWinningTicket(3, false);
        winningResult.addWinningTicket(3, false);

        assertThat(winningResult.getCount(Rank.valueOf(3, false))).isEqualTo(2);
    }
}
