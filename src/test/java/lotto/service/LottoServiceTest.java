package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.order.PurchaseOrder;
import lotto.domain.rank.Rank;
import lotto.domain.ticket.WinningTicket;
import lotto.utils.generator.MockNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("정상적으로 로또를 구매한다.")
    void 정상적으로_로또를_구매한다() {
        // given
        var lottoService = new LottoService();
        var purchaseOrder = new PurchaseOrder(1_000);

        // when
        var lottoTickets = lottoService.purchase(purchaseOrder);

        // then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.purchasedLottos()).hasSize(1);
        assertThat(lottoTickets.purchaseOrder()).isEqualTo(purchaseOrder);
    }

    @Test
    @DisplayName("로또 당첨 결과를 정상적으로 반환한다.")
    void 로또_당첨_결과를_정상적으로_반환한다() {
        // given
        var lottoMachine = new LottoMachine(new MockNumberGenerator(List.of(1, 2, 3, 4, 5, 6)));
        var lottoService = new LottoService(lottoMachine);
        var purchaseOrder = new PurchaseOrder(1_000);
        var lottoTickets = lottoService.purchase(purchaseOrder);

        // when
        var winningTicket = new WinningTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
        var result = lottoService.getWinningResult(lottoTickets, winningTicket);

        // then
        assertThat(result).isNotNull();
        assertThat(result.rankResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.rankResult().get(Rank.SECOND)).isEqualTo(0);
        assertThat(result.rankResult().get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.rankResult().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.rankResult().get(Rank.FIFTH)).isEqualTo(0);
        assertThat(result.revenue()).isEqualTo(200_000_000.0);
    }
}
