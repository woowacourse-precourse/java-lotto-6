package lotto.lottoTest;



import lotto.Application;
import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class LottoControllerTest   {



    @DisplayName("로또 구매시 구매  테스트")
    @Test
    void buyLottoTicketsNum() {
        // given
        long purchaseAmount = 8000;

        // when
        LottoController.buyLottoTickets(purchaseAmount);

        //then
        Assertions.assertThat(LottoTickets.getBuyLottoTicketsNum()).isEqualTo(8);
    }


}
