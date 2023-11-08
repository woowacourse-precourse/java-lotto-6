package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @DisplayName("로또 구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void createLottoTicketsByZeroPurchaseAmount() {
        assertThatThrownBy(() -> new LottoTickets(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoTicketsByNotDivisibleByLottoPrice() {
        assertThatThrownBy(() -> new LottoTickets(111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입한 로또 개수와 로또 당첨 결과 개수가 동일하다.")
    @Test
    void createLottoRankInfos() {
        LottoTickets lottoTickets = new LottoTickets(10000);
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(7, List.of(1, 2, 3, 4, 5, 6));

        List<LottoRankInfo> rankInfos = lottoTickets.createLottoRankInfos(winningNumbers, bonusNumber);

        assertThat(rankInfos.size()).isEqualTo(10);
    }
}