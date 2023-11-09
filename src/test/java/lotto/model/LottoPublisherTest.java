package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublisherTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void givenPurchaseAmount_Then_LottoTicketsPublished() {
        // given
        final Lotto sampleLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final LottoPublisher publisher = new LottoPublisher(() -> sampleLotto);
        final Money purchaseAmount = Money.of(8000L);

        // when
        final List<Lotto> lottoTickets = publisher.publish(purchaseAmount);

        // when
        assertThat(lottoTickets.size()).isEqualTo(8);

        for (final Lotto lottoTicket : lottoTickets) {
            final MatchCount matchCount = lottoTicket.findMatchCount(sampleLotto);
            assertThat(matchCount).isEqualTo(MatchCount.SIX);
        }
    }
}
