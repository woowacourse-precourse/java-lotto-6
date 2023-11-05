package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService(new RandomNumberGenerator());

    @Test
    @DisplayName("구매 개수를 전달했을 때, 해당 개수만큼의 로또 티켓을 반환한다.")
    public void should_returnLottoTickets_when_passAmount() {
        //given
        String money = "2000";

        //when
        List<Lotto> lottos = lottoService.buyLottoTickets(money);

        //then
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(1).getNumbers().size()).isEqualTo(6);
    }
}