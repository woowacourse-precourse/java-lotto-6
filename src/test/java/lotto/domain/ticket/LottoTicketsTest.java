package lotto.domain.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.order.PurchaseOrder;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓을 정상적으로 생성한다.")
    void 로또_티켓들을_정상적으로_생성한다() {
        // given
        var purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        var purchaseOrder = new PurchaseOrder(3_000);

        // when
        var lottoTickets = new LottoTickets(purchasedLottos, purchaseOrder);

        // then
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.purchasedLottos()).hasSize(3);
        assertThat(lottoTickets.purchaseOrder()).isEqualTo(purchaseOrder);
    }

    @Test
    @DisplayName("등수 별 당첨 횟수를 반환한다.")
    void 등수_별_당첨_횟수를_반환한다() {
        // given
        var purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        var purchaseOrder = new PurchaseOrder(3_000);
        var lottoTickets = new LottoTickets(purchasedLottos, purchaseOrder);

        // when
        var winningTicket = new WinningTicket(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
        var rankResult = lottoTickets.calculateRankResult(winningTicket);

        // then
        assertThat(rankResult).isNotNull();
        assertThat(rankResult.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankResult.get(Rank.SECOND)).isEqualTo(0);
        assertThat(rankResult.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankResult.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankResult.get(Rank.FIFTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("계산한 수익을 반환한다.")
    void 계산한_수익을_반환한다() {
        // given
        var purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        var purchaseOrder = new PurchaseOrder(3_000);
        var lottoTickets = new LottoTickets(purchasedLottos, purchaseOrder);

        // when
        var revenue = lottoTickets.revenue(3_000);

        // then
        assertThat(revenue).isEqualTo(100.0);
    }
}
