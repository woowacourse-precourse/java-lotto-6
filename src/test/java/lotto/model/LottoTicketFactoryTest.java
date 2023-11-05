package lotto.model;

import static lotto.Constants.TICKET_PRICE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketFactoryTest {

    private final LottoTicketFactory lottoTicketFactory = new LottoTicketFactory();

    @Test
    void 구매_금액에_맞춰_티켓을_발행한다() {
        final int ticketCount = 3;
        final int purchaseAmount = TICKET_PRICE * ticketCount;

        final List<Lotto> tickets = lottoTicketFactory.generateTickets(purchaseAmount);

        assertThat(tickets.size()).isEqualTo(ticketCount);
    }

    @Test
    void 티켓_가격_단위로_지불하지_않는다면_예외를_던진다() {
        final int purchaseAmount = TICKET_PRICE + TICKET_PRICE / 2;

        assertThatThrownBy(() -> lottoTicketFactory.generateTickets(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_NOT_PRICE_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void 티켓_가격이_음수라면_예외를_던진다(final int purchaseAmount) {
        assertThatThrownBy(() -> lottoTicketFactory.generateTickets(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
    }

}