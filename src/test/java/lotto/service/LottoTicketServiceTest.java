package lotto.service;

import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoTicketCount;
import lotto.service.lotto.LottoTicketService;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@Nested
@DisplayName("티켓 구매 테스트")
class LottoTicketServiceTest {
    private LottoTicketService lottoTicketService;

    @BeforeEach
    void setUp() {
        lottoTicketService = new LottoTicketService();
    }

    @Test
    @DisplayName("9000원을 구매하면 9개 티켓이 생성된다.")
    void test1() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(9000);
        LottoTicketCount lottoTicketCount = lottoTicketService.calculateTicketCount(lottoPurchaseAmount);
        assertThat(lottoTicketCount.count()).isEqualTo(9);
    }


}