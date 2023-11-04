package lotto.service;

import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketServiceTest {
    private LottoTicketService lottoTicketService;
    @BeforeEach
    void setUp(){
        lottoTicketService = new LottoTicketService();
    }

    @Test
    @DisplayName("구입 금액에 따라 구매한 로또 계수를 계산 한다.")
    void convertMoneyToTickets() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("9000");
        LottoTicketCount lottoTicketCount = lottoTicketService.convertMoneyToTickets(lottoPurchaseAmount);
        assertThat(lottoTicketCount.getCount()).isEqualTo(9);
    }
}