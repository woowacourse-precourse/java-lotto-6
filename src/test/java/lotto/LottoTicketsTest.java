package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTicketsTest {

    @DisplayName("LottoTickets의 모든 lotto의 WinningRank를 결정하여 각각 등수별 개수를 계산한다.")
    @Test
    void calculateWinningRanks() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); //1등
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 8)); //2등
        Lotto lotto3 = new Lotto(List.of(2, 3, 4, 5, 6, 7)); //3등
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumber, bonusNumber);
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto1, lotto2, lotto3));

        //when
        WinningRankCounts winningRankCounts = lottoTickets.calculateWinningRanks(new WinningRankCalculator(), lottoWinningNumbers);

        //then
        assertThat(winningRankCounts.getCount(WinningRank.FIRST)).isEqualTo(1);
        assertThat(winningRankCounts.getCount(WinningRank.SECOND)).isEqualTo(1);
        assertThat(winningRankCounts.getCount(WinningRank.THIRD)).isEqualTo(1);
    }
}