package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("구입 수량 만큼 로또를 생성한다.")
    void createLottoTicket() {
        // given
        LottoGenerator lottoGenerator = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoTicket lottoTicket = new LottoTicket(2, lottoGenerator);
        List<Lotto> lottos = lottoTicket.getLottos();

        // then
        Assertions.assertEquals(lottos.size(), 2);
    }
}