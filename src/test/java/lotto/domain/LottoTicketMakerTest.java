package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketMakerTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 생성한다.")
    @Test
    void createLottoTicketsByPurchaseAmount() {
        //given
        Money money = new Money("8000");
        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker();

        //when
        List<Lotto> lottoTickets = lottoTicketMaker.issueLottoTickets(money);

        //then
        assertThat(lottoTickets).hasSize(8);
    }
}