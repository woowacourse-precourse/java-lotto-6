package lotto.domain.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.result.WinningRank;
import lotto.domain.model.result.WinningRankCalculator;
import lotto.domain.model.result.WinningRankCounts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTicketsTest {

    @DisplayName("lottoTickets 생성에 성공한다.")
    @Test
    void createLottoWithoutDuplicatedNumber() {
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(List.of(2, 3, 4, 5, 6, 8));
        Lotto lotto3 = Lotto.from(List.of(2, 3, 4, 5, 6, 7));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto1, lotto2, lotto3));
        assertThat(lottoTickets).isNotNull();
    }

    @DisplayName("LottoTickets의 모든 lotto의 WinningRank를 결정하여 각각 등수별 개수를 계산한다.")
    @Test
    void calculateWinningRanks() {
        //given
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6)); //1등
        Lotto lotto2 = Lotto.from(List.of(2, 3, 4, 5, 6, 8)); //2등
        Lotto lotto3 = Lotto.from(List.of(2, 3, 4, 5, 6, 7)); //3등
        Lotto winningNumber = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.from(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumber, lottoNumber);
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto1, lotto2, lotto3));

        //when
        WinningRankCounts winningRankCounts = lottoTickets.collectWinningRanks(new WinningRankCalculator(), lottoWinningNumbers);

        //then
        assertThat(winningRankCounts.getCount(WinningRank.FIRST)).isEqualTo(1);
        assertThat(winningRankCounts.getCount(WinningRank.SECOND)).isEqualTo(1);
        assertThat(winningRankCounts.getCount(WinningRank.THIRD)).isEqualTo(1);
    }
}