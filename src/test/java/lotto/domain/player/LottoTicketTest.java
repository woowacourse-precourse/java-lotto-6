package lotto.domain.player;

import lotto.domain.player.playermoney.PlayerMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @DisplayName("playerMoney 에서 사용한 금액만큼 lottoTicket 을 발행한다.")
    @Test
    void lottoTicketTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(0);
        PlayerMoney playerMoney = new PlayerMoney(10000);
        playerMoney.consumeMoneyToLottoTicket(10000);
        // when
        lottoTicket = lottoTicket.issueLottoTicket(playerMoney);
        // Then
        Assertions.assertThat(lottoTicket.getLottoTicket()).isEqualTo(10);
    }
}
