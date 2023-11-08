package lotto;

import lotto.ENUM.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {
    @Test
    void tallyWinningsTest() {
        List<Integer> winningRanks = new ArrayList<>(List.of(3, 2, 5, 3, 4, 6, 7, 7, 4, 5, 2, 1));
        Calculations calculations = new Calculations();
        for (Integer winningRank : winningRanks) {
            calculations.tallyWinnings(winningRank);
        }
        Map<WinningRank, Integer> winningTally = calculations.getWinningTally();
        assertThat(winningTally.get(WinningRank.FIRST_WINNING)).isEqualTo(1);
        assertThat(winningTally.get(WinningRank.SECOND_WINNING)).isEqualTo(2);
        assertThat(winningTally.get(WinningRank.THIRD_WINNING)).isEqualTo(2);
        assertThat(winningTally.get(WinningRank.FOURTH_WINNING)).isEqualTo(2);
        assertThat(winningTally.get(WinningRank.FIFTH_WINNING)).isEqualTo(2);
    }

    @Test
    void WinningAmountTeat() {
        List<Integer> winningRanks = new ArrayList<>(List.of(3, 2, 5, 3, 4, 6, 4, 5, 2, 1));
        Long winningAmountTestValue = 0L;
        Map<Integer, Long> winningAmountTable = new HashMap<>();
        winningAmountTable.put(1, 2000000000L);
        winningAmountTable.put(2, 30000000L);
        winningAmountTable.put(3, 1500000L);
        winningAmountTable.put(4, 50000L);
        winningAmountTable.put(5, 5000L);
        winningAmountTable.put(6, 0L);
        Calculations calculations = new Calculations();
        for (Integer winningRank : winningRanks) {
            calculations.tallyWinnings(winningRank);
            winningAmountTestValue += winningAmountTable.get(winningRank);
            assertThat(calculations.getWinningAmount()).isEqualTo(winningAmountTestValue);
        }
    }
}