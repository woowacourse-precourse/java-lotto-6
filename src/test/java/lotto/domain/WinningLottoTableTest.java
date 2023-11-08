package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NOTHING;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTableTest {

    @Test
    @DisplayName("총 상금을 계산할 수 있다.")
    void calculate_total_winnings() {
        // given
        WinningLottoTable winningLottoTable = createWinningLottoTable();

        // when
        double totalWinnings = winningLottoTable.calculateTotalWinnings();

        // then
        assertThat(totalWinnings).isEqualTo(2031555000);
    }

    private WinningLottoTable createWinningLottoTable() {
        Map<Rank, Integer> winningLottoTable = new HashMap<>();
        winningLottoTable.put(FIRST, 1);
        winningLottoTable.put(SECOND, 1);
        winningLottoTable.put(THIRD, 1);
        winningLottoTable.put(FOURTH, 1);
        winningLottoTable.put(FIFTH, 1);
        winningLottoTable.put(NOTHING, 6);
        return new WinningLottoTable(winningLottoTable);
    }

}