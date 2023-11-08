package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    @DisplayName("로또 티켓을 정상적으로 구매할 수 있다.")
    @Test
    void purchaseLottoTicket() {
        int amount = 5000;
        LottoTicket lottoTicket = LottoTicket.purchase(amount);

        assertThat(lottoTicket.getTickets()).hasSize(amount / 1000);
    }

    @DisplayName("로또 티켓을 구매할 때 1,000원 미만의 금액을 입력하면 예외가 발생한다.")
    @Test
    void purchaseLottoTicketWithInvalidAmount() {
        int amount = 500;
        assertThatThrownBy(() -> LottoTicket.purchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 한 장의 가격은 1,000원입니다. 1,000원 이상의 금액을 입력해주세요.");
    }

    @DisplayName("로또 티켓을 구매할 때 1,000원으로 나누어 떨어지지 않는 금액을 입력하면 예외가 발생한다.")
    @Test
    void purchaseLottoTicketWithInvalidAmount2() {
        int amount = 2500;
        assertThatThrownBy(() -> LottoTicket.purchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 한 장은 1,000원입니다.");
    }

    @DisplayName("로또 티켓의 당첨 통계를 정상적으로 계산할 수 있다.")
    @Test
    void calculateWinningStatistic() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26)),
                new Lotto(Arrays.asList(31, 32, 33, 34, 35, 36)),
                new Lotto(Arrays.asList(41, 42, 43, 44, 45, 46))
        );
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6),10);

        WinningStatistic winningStatistic = lottoTicket.calculateResult(winningNumbers);

        assertThat(winningStatistic.getCountByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(winningStatistic.getCountByRank(Rank.SECOND)).isEqualTo(0);
        assertThat(winningStatistic.getCountByRank(Rank.THIRD)).isEqualTo(0);
        assertThat(winningStatistic.getCountByRank(Rank.FOURTH)).isEqualTo(0);
        assertThat(winningStatistic.getCountByRank(Rank.FIFTH)).isEqualTo(0);
        assertThat(winningStatistic.getCountByRank(Rank.MISS)).isEqualTo(4);
    }

}