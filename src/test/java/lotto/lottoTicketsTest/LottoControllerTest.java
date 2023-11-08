package lotto.lottoTicketsTest;



import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class LottoControllerTest   {



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

    @DisplayName("로또 목록 갯수 테스트")
    @Test
    void getBuyLottoTicketsNum(){
        long purchaseAmount = 8000;
        LottoController.getInstance().buyLottoTickets(purchaseAmount);

        Assertions.assertThat(LottoController.getInstance().getBuyLottoTicketsNum()).isEqualTo(8);
    }

    @DisplayName("로또목록 확인 테스트")
    @Test
    void getBuyLottoTickets() {
        // given
        long purchaseAmount = 8000;
        LottoController.getInstance().buyLottoTickets(purchaseAmount);
        // when
        List<Lotto> lottoTickets = LottoController.getInstance().getBuyLottoTickets();


        //then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(8);
    }


}
