package lotto.lottoTicketsTest;

import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {
    @DisplayName("로또 구매시 구매  테스트")
    @Test
    void buyLottoTicketsNum() {
        // given
        long purchaseAmount = 8000;

        // when
        LottoController.getInstance().buyLottoTickets(purchaseAmount);

        //then
        Assertions.assertThat(LottoTickets.getInstance().getBuyLottoTickets().size()).isEqualTo(8);
    }
}
