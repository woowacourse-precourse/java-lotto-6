package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @DisplayName("당첨 등급을 정상적으로 계산할 수 있다.")
    @Test
    void calculateRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        Lotto lotto3 = new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26));

        Rank rank1 = winningNumbersObj.calculateRank(lotto1);
        Rank rank2 = winningNumbersObj.calculateRank(lotto2);
        Rank rank3 = winningNumbersObj.calculateRank(lotto3);

        assertThat(rank1).isEqualTo(Rank.FIRST);
        assertThat(rank2).isEqualTo(Rank.MISS);
        assertThat(rank3).isEqualTo(Rank.MISS);
    }

}