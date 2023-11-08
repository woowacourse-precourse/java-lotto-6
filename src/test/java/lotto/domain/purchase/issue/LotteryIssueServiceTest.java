package lotto.domain.purchase.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryIssueServiceTest {

    private LotteryIssueService lotteryIssueService;

    @BeforeEach
    void setUp() {
        lotteryIssueService = new LotteryIssueService();
    }

    @AfterEach
    void tearDown() {
        lotteryIssueService = null;
    }

    @Test
    @DisplayName("티켓 개수만큼 로또를 발행합니다.")
    void 티켓개수만큼_로또발행() {
        // GIVEN
        Integer lottoTicketCount = 3;

        // WHEN
        List<Lotto> lottos = lotteryIssueService.issueLottoAmountOf(lottoTicketCount);

        // THEN
        assertEquals(lottos.size(), lottoTicketCount);
    }
}