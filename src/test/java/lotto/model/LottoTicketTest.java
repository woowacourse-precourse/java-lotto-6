package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    public void 로또_발행_기능_테스트() {
        // given
        final Money purchaseLotto = new Money(3000L);

        // when
        final LottoTicket lottoTicket = LottoTicket.create(purchaseLotto);

        // then
        Assertions.assertEquals(lottoTicket.getLottos().size(), 3);
    }

    @Test
    public void 로또_개수가_1개보다_작으면_예외가_발생한다() {
        // given
        final Money purchaseLotto = new Money(0L);

        // then
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> LottoTicket.create(purchaseLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}