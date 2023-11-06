package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    public void 로또_발행_기능_테스트() {
        // given
        final int purchaseLottoNumber = 3;

        // when
        final LottoTicket lottoTicket = LottoTicket.create(purchaseLottoNumber);

        // then
        Assertions.assertEquals(lottoTicket.getLottos().size(), 3);
    }
}