package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("구입 수량 만큼 로또를 생성한다.")
    void createLottoTicket() {
        // given
        Money money = new Money(2000);
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoTicket lottoTicket = lottoMachine.buy(money, () -> new Lotto(Arrays.asList(1,2,3,4,5,6)));
        List<Lotto> lottos = lottoTicket.getLottos();

        // then
        Assertions.assertEquals(2, lottos.size());
    }
}