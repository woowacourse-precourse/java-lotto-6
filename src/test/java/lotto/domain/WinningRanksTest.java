package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRanksTest {
    @DisplayName("당첨 내역을 계산한다.")
    @Test
    void calculateRanks() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 15));
        lottos.add(lotto1);
        lottos.add(lotto2);
        WinningNumber winningNumber = new WinningNumber(List.of(34, 21, 22, 43, 15, 7));
        BonusNumber bonusNumber = new BonusNumber(10);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
        WinningRanks winningRanks = new WinningRanks(lottos, winningNumbers);

        // when
        List<Rank> ranks = winningRanks.calculateRanks();

        // then
        assertThat(ranks.size()).isEqualTo(lottos.size());
        assertThat(ranks.get(1)).isEqualTo(Rank.FIFTH);
    }
}